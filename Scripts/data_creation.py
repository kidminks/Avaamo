import psycopg2
import json

import random
import string

from datetime import date

today = date.today()


def get_random_string(length):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(length))

def generate_user(name, type, cursor):
	password = get_random_string(8)
	print("INSERT INTO users(name, type, password, created_at) values(%s, %s, %s, %s)", (name, type, password, today))
	cursor.execute("INSERT INTO users(name, type, password, created_at) values(%s, %s, %s, %s)", (name, type, password, today))

def generate_topic(creator_id, subject, content, status, permalink, type, created_time, cursor):
	print("INSERT INTO topics(subject, content, status, permalink, type, creator_id) values(%s, %s, %s, %s, %s, %s)", (subject, content, status, permalink, type, creator_id))
	cursor.execute("INSERT INTO topics(subject, content, status, permalink, type, creator_id, created_at, updated_at) values(%s, %s, %s, %s, %s, %s, %s, %s)", (subject, content, status, permalink, type, creator_id, created_time, today))

def generate_user_entries(cursor):
	with open('dump/users.json') as f:
		data = json.load(f)
	users = data['data']
	for user in users:
		generate_user(user["name"], user["type"], cursor)

def generate_topics(cursor):
	with open('dump/topics.json') as f:
		data = json.load(f)
	topics = data['data']
	for topic in topics:
		cursor.execute("SELECT * from users where name = "+"'"+topic["creator"]["name"]+"'"+";")
		record = cursor.fetchone()
		creator_id = record[0]
		generate_topic(creator_id, topic["subject"], topic["content"], topic["status"], topic["permalink"], topic["type"], topic["createdTime"], cursor)

try:
    connection = psycopg2.connect(user = "postgres",
                                  password = "postgres",
                                  host = "localhost",
                                  port = "5432",
                                  database = "avaamo_test")

    cursor = connection.cursor()
    # Print PostgreSQL Connection properties
    print ( connection.get_dsn_parameters(),"\n")

    # Print PostgreSQL version
    cursor.execute("SELECT version();")
    record = cursor.fetchone()
    print("You are connected to - ", record,"\n")
    generate_user_entries(cursor)
    generate_topics(cursor)
    connection.commit()

except (Exception, psycopg2.Error) as error :
    print ("Error", error)
finally:
    #closing database connection.
        if(connection):
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed")
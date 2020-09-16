CREATE TABLE IF NOT EXISTS users(
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	type VARCHAR(100) DEFAULT 'ENDUSER',
	password VARCHAR(100) NOT NULL,
	created_at DATE
);

CREATE TABLE IF NOT EXISTS topics(
	id SERIAL PRIMARY KEY,
	subject TEXT,
	content TEXT NOT NULL,
	status VARCHAR(100) DEFAULT 'PUBLISH',
	permalink TEXT NOT NULL,
	type VARCHAR(100) NOT NULL,
	views BIGINT DEFAULT 0,
	likes BIGINT DEFAULT 0,
	creator_id BIGINT,
	created_by VARCHAR(100),
	updated_by VARCHAR(100),
	created_at DATE,
	updated_at DATE
);

CREATE TABLE IF NOT EXISTS topic_comment_relations(
	id SERIAL PRIMARY KEY,
	topic_id BIGINT NOT NULL,
	comment_id BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS tags(
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	permalink VARCHAR(100),
	created_by VARCHAR(100),
	updated_by VARCHAR(100),
	created_at DATE,
	updated_at DATE
);

CREATE TABLE IF NOT EXISTS topic_tag_relations(
	id SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS attachments(
	id SERIAL PRIMARY KEY,
	file_name TEXT NOT NULL,
	file_url TEXT NOT NULL,
	entity_type VARCHAR(100) NOT NULL,
	entity_id BIGINT NOT NULL,
	created_by VARCHAR(100),
	updated_by VARCHAR(100),
	created_at DATE,
	updated_at DATE
);


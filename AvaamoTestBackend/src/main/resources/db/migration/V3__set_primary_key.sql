ALTER TABLE topics
ADD CONSTRAINT fk_creator_id FOREIGN KEY (creator_id) REFERENCES users (id);

ALTER TABLE topic_comment_relations
ADD CONSTRAINT fk_topic_id FOREIGN KEY (topic_id) REFERENCES topics (id);

ALTER TABLE topic_comment_relations
ADD CONSTRAINT fk_comment_id FOREIGN KEY (comment_id) REFERENCES topics (id);


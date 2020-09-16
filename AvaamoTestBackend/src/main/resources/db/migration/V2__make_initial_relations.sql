ALTER TABLE topic_tag_relations
ADD COLUMN topic_id BIGINT NOT NULL;
ALTER TABLE topic_tag_relations
ADD CONSTRAINT fk_topics_id FOREIGN KEY (topic_id) REFERENCES topics (id);

ALTER TABLE topic_tag_relations
ADD COLUMN tag_id BIGINT NOT NULL;
ALTER TABLE topic_tag_relations
ADD CONSTRAINT fk_tags_id FOREIGN KEY (tag_id) REFERENCES tags (id);


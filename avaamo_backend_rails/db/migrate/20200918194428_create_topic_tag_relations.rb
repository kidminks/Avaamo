class CreateTopicTagRelations < ActiveRecord::Migration[6.0]
  def change
    create_table :topic_tag_relations do |t|
      t.belongs_to :topic
      t.belongs_to :tag

      t.timestamps
    end
  end
end

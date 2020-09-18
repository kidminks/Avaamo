class CreateTopicCommentRelations < ActiveRecord::Migration[6.0]
  def change
    create_table :topic_comment_relations do |t|
      t.belongs_to :topic
      t.belongs_to :comment

      t.timestamps
    end
  end
end

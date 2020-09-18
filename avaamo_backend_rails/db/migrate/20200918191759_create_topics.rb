class CreateTopics < ActiveRecord::Migration[6.0]
  def change
    create_table :topics do |t|
      t.string :subject
      t.string :content
      t.integer :topic_type
      t.integer :status
      t.string :permalink
      t.integer :view, default: 0
      t.integer :likes, default: 0
      t.belongs_to :creator

      t.timestamps
    end
  end
end

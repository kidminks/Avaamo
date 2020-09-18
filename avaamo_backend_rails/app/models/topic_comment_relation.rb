class TopicCommentRelation < ApplicationRecord
  belongs_to :topic
  belongs_to :comment, class_name: 'Topic'
end

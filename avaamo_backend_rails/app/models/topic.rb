class Topic < ApplicationRecord
  include Attachable
  belongs_to :creator, class_name: 'User'
  has_many :tags, through: :topic_tag_relation

  has_many :comments_association, :class_name => "TopicCommentRelation"
  has_many :comments, :through => :comments_association, :source => :comment
  has_many :inverse_comments_association, :class_name => "TopicCommentRelation", :foreign_key => "comment_id"
  has_many :inverse_comments, :through => :inverse_comments_association, :source => :topic

  enum topic_type: [:discussion, :idea, :question, :comment]
  enum status: [:published, :draft]

  scope :subject_search, -> (subject = ""){
    where(subject: subject)
  }

  scope :not_comments, -> (){
    where.not(topic_type: :comment)
  }

  scope :filtered, -> (options = {}){
    query = all
    query = query.subject_search(options[:subject]) if options[:subject].present?
    query = query.not_comments
    query
  }
end

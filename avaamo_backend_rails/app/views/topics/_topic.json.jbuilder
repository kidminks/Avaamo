json.extract! topic, :id, :subject, :content, :topic_type, :status, :permalink, :view, :likes, :created_at, :updated_at
json.creator do
  json.partial! "users/user", user: topic.creator
end
json.comments do
  json.array! topic.comments, partial: "topics/comment", as: :comment
end
json.url topic_url(topic, format: :json)

json.extract! comment, :id, :subject, :content, :created_at
json.creator do
  json.partial! "users/user", user: comment.creator
end
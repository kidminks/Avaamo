json.content do
  json.array! @topics, partial: "topics/topic", as: :topic
end
json.totalPages @pagy.pages
json.extract! attachment, :id, :file_name, :file_url, :attachableable_id, :attachableable_type, :created_at, :updated_at
json.url attachment_url(attachment, format: :json)

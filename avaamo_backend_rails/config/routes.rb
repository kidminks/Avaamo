Rails.application.routes.draw do
  resources :tags
  resources :attachments
  resources :topics
  resources :users
  get '/topics/search/all-subjects', to: 'topics#all_subjects'
  # For details on the DSL available within this file, see https://guides.rubyonrails.org/routing.html
end

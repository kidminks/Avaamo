class User < ApplicationRecord
  include Attachable
  enum user_type: [:enduser, :supportrep]

  scope :login_cred_check, -> (name, password) {
    where(name: name).where(password: password)
  }

  scope :filtered, -> (options = {}) {
    query = all
    query = query.login_cred_check(options[:name], options[:password]) if options[:name].present? && options[:password].present?
    query
  }
end

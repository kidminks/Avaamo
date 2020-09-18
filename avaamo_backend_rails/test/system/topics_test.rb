require "application_system_test_case"

class TopicsTest < ApplicationSystemTestCase
  setup do
    @topic = topics(:one)
  end

  test "visiting the index" do
    visit topics_url
    assert_selector "h1", text: "Topics"
  end

  test "creating a Topic" do
    visit topics_url
    click_on "New Topic"

    fill_in "Content", with: @topic.content
    fill_in "Likes", with: @topic.likes
    fill_in "Permalink", with: @topic.permalink
    fill_in "Status", with: @topic.status
    fill_in "Subject", with: @topic.subject
    fill_in "Type", with: @topic.type
    fill_in "User", with: @topic.user_id
    fill_in "View", with: @topic.view
    click_on "Create Topic"

    assert_text "Topic was successfully created"
    click_on "Back"
  end

  test "updating a Topic" do
    visit topics_url
    click_on "Edit", match: :first

    fill_in "Content", with: @topic.content
    fill_in "Likes", with: @topic.likes
    fill_in "Permalink", with: @topic.permalink
    fill_in "Status", with: @topic.status
    fill_in "Subject", with: @topic.subject
    fill_in "Type", with: @topic.type
    fill_in "User", with: @topic.user_id
    fill_in "View", with: @topic.view
    click_on "Update Topic"

    assert_text "Topic was successfully updated"
    click_on "Back"
  end

  test "destroying a Topic" do
    visit topics_url
    page.accept_confirm do
      click_on "Destroy", match: :first
    end

    assert_text "Topic was successfully destroyed"
  end
end

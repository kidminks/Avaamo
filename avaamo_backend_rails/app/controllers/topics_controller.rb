class TopicsController < ApplicationController
  include Pagy::Backend
  before_action :set_topic, only: [:show, :edit, :update, :destroy]

  # GET /topics
  # GET /topics.json
  def index
    @pagy, @topics = pagy(Topic.filtered(index_params).order(created_at: :desc), items: 5)
  end

  # GET /topics/1
  # GET /topics/1.json
  def show
  end

  # GET /topics/new
  def new
    @topic = Topic.new
  end

  # GET /topics/1/edit
  def edit
  end

  # POST /topics
  # POST /topics.json
  def create
    @topic = Topic.new(topic_params)
    unless @topic.save
      render json: @topic.errors, status: :unprocessable_entity
    end
    if @topic.comment?
      topic_comment_relation = TopicCommentRelation.new
      topic_comment_relation.comment = @topic
      topic_comment_relation.topic = Topic.find params[:topic_id_for_comment]
      topic_comment_relation.save
    end
  end

  # PATCH/PUT /topics/1
  # PATCH/PUT /topics/1.json
  def update
    unless @topic.update(topic_params)
      render json: @user.errors, status: :unprocessable_entity
    end
  end

  # DELETE /topics/1
  # DELETE /topics/1.json
  def destroy
    @topic.destroy
    respond_to do |format|
      format.html { redirect_to topics_url, notice: 'Topic was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  def all_subjects
    @subjects = Topic.all.pluck(:id, :subject)
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_topic
      @topic = Topic.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def topic_params
      params.require(:topic).permit(:subject, :content, :topic_type, :status, :permalink, :view, :likes, :creator_id, :topic_id_for_comment)
    end

    def index_params
      params.permit(:page, :subject)
    end
end

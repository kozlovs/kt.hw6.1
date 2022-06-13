object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0L

    fun add(post: Post): Post {
        posts += post.copy(id = getId())
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, thisPost) in posts.withIndex()) {
            if (thisPost.id == post.id) {
                posts[index] = thisPost.copy(
                    fromId = thisPost.fromId,
                    createdBy = thisPost.createdBy,
                    replyOwnerId = thisPost.replyOwnerId,
                    replyPostId = thisPost.replyPostId,
                    signerId = thisPost.signerId,
                    attachments = thisPost.attachments,
                    original = thisPost.original,
                    postSource = thisPost.postSource,
                    geo = thisPost.geo,
                    copyHistory = thisPost.copyHistory,
                    text = thisPost.text,
                    friendsOnly = thisPost.friendsOnly,
                    comments = thisPost.comments,
                    likes = thisPost.likes,
                    reposts = thisPost.reposts,
                    postType = thisPost.postType,
                    canPin = thisPost.canPin,
                    canDelete = thisPost.canDelete,
                    canEdit = thisPost.canEdit,
                    isPinned = thisPost.isPinned,
                    markedAsAds = thisPost.markedAsAds,
                    isFavorite = thisPost.isFavorite,
                    id = getId()
                )
                return true
            }
        }
        return false
    }

    private fun getId(): Long {
        lastId += 1
        return lastId
    }
}
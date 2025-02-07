package com.example.db

import androidx.room.Entity
import androidx.room.PrimaryKey

//data class RepositoryEntity(
//    @PrimaryKey val id: Int,
//    val incompleteResults: Boolean?,
//    val totalCount: Int?,
//    val items: List<ItemEntity>?
//) {
//    @Entity(tableName = "repository_item")
//    data class ItemEntity(
//        @PrimaryKey val id: Int,
//        val name: String?,
//        val fullName: String?,
//        val private: Boolean?,
//        val owner: OwnerEntity?,
//        val htmlUrl: String?,
//        val description: String?,
//        val fork: Boolean?,
//        val url: String?,
//        val forksCount: Int?,
//        val stargazersCount: Int?,
//        val watchersCount: Int?,
//        val language: String?,
//        val openIssuesCount: Int?,
//        val defaultBranch: String?,
//        val topics: List<String>?,
//        val createdAt: String?,
//        val updatedAt: String?,
//        val pushedAt: String?,
//        val license: LicenseEntity?
//    ) {
//        @Entity(tableName = "repository_license")
//        data class LicenseEntity(
//            @PrimaryKey val key: String,
//            val name: String?,
//            val spdxId: String?,
//            val url: String?
//        )
//
//        @Entity(tableName = "repository_owner")
//        data class OwnerEntity(
//            @PrimaryKey val id: Int,
//            val login: String?,
//            val avatarUrl: String?,
//            val htmlUrl: String?,
//            val type: String?,
//            val siteAdmin: Boolean?
//        )
//    }
//}

@Entity(tableName = "repository_item")
data class RepositoryEntity(
    @PrimaryKey val id: Int?,
    val name: String?,
    val fullName: String?,
    val private: Boolean?,
    val owner: OwnerEntity?,
    val htmlUrl: String?,
    val description: String?,
    val fork: Boolean?,
    val forks: Int?,
    val forksCount: Int?,
    val stargazersCount: Int?,
    val watchersCount: Int?,
    val language: String?,
    val openIssues: Int?,
    val openIssuesCount: Int?,
    val defaultBranch: String?,
    val topics: List<String>?,
    val createdAt: String?,
    val updatedAt: String?,
    val pushedAt: String?,
    val allowForking: Boolean?,
    val archived: Boolean?,
    val disabled: Boolean?,
    val visibility: String?,
    val score: Double?,
    val webCommitSignoffRequired: Boolean?,
    val url: String?,
    val cloneUrl: String?,
    val sshUrl: String?,
    val svnUrl: String?,
    val license: LicenseEntity?,
    val archiveUrl: String?,
    val assigneesUrl: String?,
    val blobsUrl: String?,
    val branchesUrl: String?,
    val collaboratorsUrl: String?,
    val commentsUrl: String?,
    val commitsUrl: String?,
    val compareUrl: String?,
    val contentsUrl: String?,
    val contributorsUrl: String?,
    val deploymentsUrl: String?,
    val downloadsUrl: String?,
    val eventsUrl: String?,
    val forksUrl: String?,
    val gitCommitsUrl: String?,
    val gitRefsUrl: String?,
    val gitTagsUrl: String?,
    val gitUrl: String?,
    val hasDiscussions: Boolean?,
    val hasDownloads: Boolean?,
    val hasIssues: Boolean?,
    val hasPages: Boolean?,
    val hasProjects: Boolean?,
    val hasWiki: Boolean?,
    val homepage: String?,
    val hooksUrl: String?,
    val isTemplate: Boolean?,
    val issueCommentUrl: String?,
    val issueEventsUrl: String?,
    val issuesUrl: String?,
    val keysUrl: String?,
    val labelsUrl: String?,
    val languagesUrl: String?,
    val mergesUrl: String?,
    val milestonesUrl: String?,
    val mirrorUrl: String?,
    val nodeId: String?,
    val notificationsUrl: String?,
    val pullsUrl: String?,
    val releasesUrl: String?,
    val size: Int?,
    val stargazersUrl: String?,
    val statusesUrl: String?,
    val subscribersUrl: String?,
    val subscriptionUrl: String?,
    val tagsUrl: String?,
    val teamsUrl: String?,
    val treesUrl: String?,
    val watchers: Int?
) {
    @Entity(tableName = "repository_license")
    data class LicenseEntity(
        @PrimaryKey val key: String?,
        val name: String?,
        val nodeId: String?,
        val spdxId: String?,
        val url: String?
    )

    @Entity(tableName = "repository_owner")
    data class OwnerEntity(
        @PrimaryKey val id: Int?,
        val login: String?,
        val avatarUrl: String?,
        val htmlUrl: String?,
        val siteAdmin: Boolean?,
        val eventsUrl: String?,
        val followersUrl: String?,
        val followingUrl: String?,
        val gistsUrl: String?,
        val gravatarId: String?,
        val organizationsUrl: String?,
        val receivedEventsUrl: String?,
        val reposUrl: String?,
        val starredUrl: String?,
        val subscriptionsUrl: String?,
        val type: String?,
        val userViewType: String?
    )
}

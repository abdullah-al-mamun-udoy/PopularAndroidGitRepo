package com.example.data.repository

import android.util.Log
import com.example.db.RepositoryDao
import com.example.db.RepositoryEntity
import com.example.network.api.ApiInterface
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val api: ApiInterface,
    private val repositoryDao: RepositoryDao
) {
    // Fetch the data
    suspend fun fetchRepo(query: String, sort: String, order: String, perPage: Int): List<RepositoryEntity> {
        return try {
            // Step 1: Get data from the local database
            val localRepos = repositoryDao.getAllRepositories()
            if (localRepos.isNotEmpty()) {
                Log.d("checkDb", "come at db ${localRepos.size}")
                return localRepos  // Return local data if available
            }

            // Step 2: Fetch from API if local data is empty
            val remoteRepos = api.searchRepositories(query = query, sort = sort, order = order, perPage = perPage)
            Log.d("checkDb", "come to call api ${localRepos.size}")


            // Step 3: Map API response to Room entities
            val entities = remoteRepos.items?.map { item ->
                RepositoryEntity(
                    id = item?.id ?: 0,
                    name = item?.name.orEmpty(),
                    fullName = item?.fullName.orEmpty(),
                    private = item?.private ?: false,
                    owner = item?.owner?.let { owner ->
                        RepositoryEntity.OwnerEntity(
                            id = owner.id ?: 0,
                            login = owner.login.orEmpty(),
                            avatarUrl = owner.avatarUrl.orEmpty(),
                            htmlUrl = owner.htmlUrl.orEmpty(),
                            type = owner.type.orEmpty(),
                            siteAdmin = owner.siteAdmin ?: false,
                            eventsUrl = owner.eventsUrl.orEmpty(),
                            followersUrl = owner.followersUrl.orEmpty(),
                            followingUrl = owner.followingUrl.orEmpty(),
                            gistsUrl = owner.gistsUrl.orEmpty(),
                            gravatarId = owner.gravatarId.orEmpty(),
                            organizationsUrl = owner.organizationsUrl.orEmpty(),
                            receivedEventsUrl = owner.receivedEventsUrl.orEmpty(),
                            reposUrl = owner.reposUrl.orEmpty(),
                            starredUrl = owner.starredUrl.orEmpty(),
                            subscriptionsUrl = owner.subscriptionsUrl.orEmpty(),
                            userViewType = owner.userViewType.orEmpty()
                        )
                    },
                    htmlUrl = item?.htmlUrl.orEmpty(),
                    description = item?.description.orEmpty(),
                    fork = item?.fork ?: false,

                    forksCount = item?.forksCount ?: 0,
                    stargazersCount = item?.stargazersCount ?: 0,
                    watchersCount = item?.watchersCount ?: 0,
                    language = item?.language.orEmpty(),
                    openIssuesCount = item?.openIssuesCount ?: 0,
                    defaultBranch = item?.defaultBranch.orEmpty(),
                    topics = item?.topics ?: emptyList(),
                    createdAt = item?.createdAt.orEmpty(),
                    updatedAt = item?.updatedAt.orEmpty(),
                    pushedAt = item?.pushedAt.orEmpty(),
                    license = item?.license?.let { license ->
                        RepositoryEntity.LicenseEntity(
                            key = license.key.orEmpty(),
                            name = license.name.orEmpty(),
                            spdxId = license.spdxId.orEmpty(),
                            url = license.url.orEmpty(),
                            nodeId = license.nodeId.orEmpty()
                        )
                    },
                    allowForking = item?.allowForking
                        ?: false,
                    archived = item?.archived ?: false,
                    disabled = item?.disabled ?: false,
                    visibility = item?.visibility.orEmpty(),
                    score = item?.score ?: 0.0,
                    webCommitSignoffRequired = item?.webCommitSignoffRequired
                        ?: false,
                    cloneUrl = item?.cloneUrl.orEmpty(),
                    sshUrl = item?.sshUrl.orEmpty(),
                    svnUrl = item?.svnUrl.orEmpty(),
                    archiveUrl = item?.archiveUrl.orEmpty(),
                    assigneesUrl = item?.assigneesUrl.orEmpty(),
                    blobsUrl = item?.blobsUrl.orEmpty(),
                    branchesUrl = item?.branchesUrl.orEmpty(),
                    collaboratorsUrl = item?.collaboratorsUrl.orEmpty(),
                    commentsUrl = item?.commentsUrl.orEmpty(),
                    commitsUrl = item?.commitsUrl.orEmpty(),
                    compareUrl = item?.compareUrl.orEmpty(),
                    contentsUrl = item?.contentsUrl.orEmpty(),
                    contributorsUrl = item?.contributorsUrl.orEmpty(),
                    deploymentsUrl = item?.deploymentsUrl.orEmpty(),
                    downloadsUrl = item?.downloadsUrl.orEmpty(),
                    eventsUrl = item?.eventsUrl.orEmpty(),
                    forksUrl = item?.forksUrl.orEmpty(),
                    gitCommitsUrl = item?.gitCommitsUrl.orEmpty(),
                    gitRefsUrl = item?.gitRefsUrl.orEmpty(),
                    gitTagsUrl = item?.gitTagsUrl.orEmpty(),
                    gitUrl = item?.gitUrl.orEmpty(),
                    hasDiscussions = item?.hasDiscussions
                        ?: false,
                    hasDownloads = item?.hasDownloads
                        ?: false,
                    hasIssues = item?.hasIssues ?: false,
                    hasPages = item?.hasPages ?: false,
                    hasProjects = item?.hasProjects
                        ?: false,
                    hasWiki = item?.hasWiki ?: false,
                    homepage = item?.homepage.orEmpty(),
                    hooksUrl = item?.hooksUrl.orEmpty(),
                    isTemplate = item?.isTemplate ?: false,
                    issueCommentUrl = item?.issueCommentUrl.orEmpty(),
                    issueEventsUrl = item?.issueEventsUrl.orEmpty(),
                    issuesUrl = item?.issuesUrl.orEmpty(),
                    keysUrl = item?.keysUrl.orEmpty(),
                    labelsUrl = item?.labelsUrl.orEmpty(),
                    languagesUrl = item?.languagesUrl.orEmpty(),
                    mergesUrl = item?.mergesUrl.orEmpty(),
                    milestonesUrl = item?.milestonesUrl.orEmpty(),
                    mirrorUrl = item?.mirrorUrl,
                    nodeId = item?.nodeId.orEmpty(),
                    notificationsUrl = item?.notificationsUrl.orEmpty(),
                    pullsUrl = item?.pullsUrl.orEmpty(),
                    releasesUrl = item?.releasesUrl.orEmpty(),
                    size = item?.size ?: 0,
                    stargazersUrl = item?.stargazersUrl.orEmpty(),
                    statusesUrl = item?.statusesUrl.orEmpty(),
                    subscribersUrl = item?.subscribersUrl.orEmpty(),
                    subscriptionUrl = item?.subscriptionUrl.orEmpty(),
                    tagsUrl = item?.tagsUrl.orEmpty(),
                    teamsUrl = item?.teamsUrl.orEmpty(),
                    treesUrl = item?.treesUrl.orEmpty(),
                    forks = item?.forks ?: 0,
                    openIssues = item?.openIssues ?: 0,
                    url = item?.url.orEmpty(),
                    watchers = item?.watchers?:0
                )
            } ?: emptyList()


            // Step 4: Store mapped entities into Room database
            repositoryDao.insertRepositories(entities)

            //Return only the `entities` list (List<RepositoryEntity>)
            entities

        } catch (e: Exception) {
            e.printStackTrace()  // Log the error for debugging
            emptyList()  // Return empty list in case of failure
        }
    }
}


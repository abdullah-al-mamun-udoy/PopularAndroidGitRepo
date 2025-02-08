package com.example.popularandroidgitrepo.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Resource
import com.example.data.repository.AppRepository
import com.example.network.model.GitAndroidRepositoryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val appRepo: AppRepository
) : ViewModel() {

    private val _fetchRepo =
        MutableStateFlow<Resource<List<GitAndroidRepositoryResponse.Item>>>(Resource.Loading)
    val fetchRepo = _fetchRepo.asStateFlow()

    private val _isLoading = MutableStateFlow(true) // Track loading state
    val isLoading = _isLoading.asStateFlow()

    init {
        // Call the repository method on initialization
        getGitRepo(
            query = "Android",
            sort = "stars",
            order = "desc",
            perPage = 20
        )
    }

    fun getGitRepo(
        query: String,
        sort: String,
        order: String,
        perPage: Int
    ) {
        viewModelScope.launch {
            try {
                _isLoading.value = true // Set loading to true before API call
                // Fetching data from repository
                val response = appRepo.fetchRepo(query, sort, order, perPage)

                // Convert List<RepositoryEntity.ItemEntity> → List<GitAndroidRepositoryResponse.Item>
                val mappedList: List<GitAndroidRepositoryResponse.Item> = response.map { entity ->
                    GitAndroidRepositoryResponse.Item(
                        allowForking = entity.allowForking,
                        archiveUrl = entity.archiveUrl,
                        archived = entity.archived,
                        assigneesUrl = entity.assigneesUrl,
                        blobsUrl = entity.blobsUrl,
                        branchesUrl = entity.branchesUrl,
                        cloneUrl = entity.cloneUrl,
                        collaboratorsUrl = entity.collaboratorsUrl,
                        commentsUrl = entity.commentsUrl,
                        commitsUrl = entity.commitsUrl,
                        compareUrl = entity.compareUrl,
                        contentsUrl = entity.contentsUrl,
                        contributorsUrl = entity.contributorsUrl,
                        createdAt = entity.createdAt,
                        defaultBranch = entity.defaultBranch,
                        deploymentsUrl = entity.deploymentsUrl,
                        description = entity.description,
                        disabled = entity.disabled,
                        downloadsUrl = entity.downloadsUrl,
                        eventsUrl = entity.eventsUrl,
                        fork = entity.fork,
                        forks = entity.forks,
                        forksCount = entity.forksCount,
                        forksUrl = entity.forksUrl,
                        fullName = entity.fullName,
                        gitCommitsUrl = entity.gitCommitsUrl,
                        gitRefsUrl = entity.gitRefsUrl,
                        gitTagsUrl = entity.gitTagsUrl,
                        gitUrl = entity.gitUrl,
                        hasDiscussions = entity.hasDiscussions,
                        hasDownloads = entity.hasDownloads,
                        hasIssues = entity.hasIssues,
                        hasPages = entity.hasPages,
                        hasProjects = entity.hasProjects,
                        hasWiki = entity.hasWiki,
                        homepage = entity.homepage,
                        hooksUrl = entity.hooksUrl,
                        htmlUrl = entity.htmlUrl,
                        id = entity.id,
                        isTemplate = entity.isTemplate,
                        issueCommentUrl = entity.issueCommentUrl,
                        issueEventsUrl = entity.issueEventsUrl,
                        issuesUrl = entity.issuesUrl,
                        keysUrl = entity.keysUrl,
                        labelsUrl = entity.labelsUrl,
                        language = entity.language,
                        languagesUrl = entity.languagesUrl,
                        license = entity.license?.let { license ->
                            GitAndroidRepositoryResponse.Item.License(
                                key = license.key ?: "",
                                name = license.name ?: "",
                                nodeId = license.nodeId ?: "",
                                spdxId = license.spdxId ?: "",
                                url = license.url ?: ""
                            )
                        },
                        mergesUrl = entity.mergesUrl,
                        milestonesUrl = entity.milestonesUrl,
                        mirrorUrl = entity.mirrorUrl,
                        name = entity.name,
                        nodeId = entity.nodeId,
                        notificationsUrl = entity.notificationsUrl,
                        openIssues = entity.openIssues,
                        openIssuesCount = entity.openIssuesCount,
                        owner = entity.owner?.let { owner ->
                            GitAndroidRepositoryResponse.Item.Owner(
                                id = owner.id,
                                login = owner.login,
                                avatarUrl = owner.avatarUrl
                            )
                        },
                        `private` = entity.private,
                        pullsUrl = entity.pullsUrl,
                        pushedAt = entity.pushedAt,
                        releasesUrl = entity.releasesUrl,
                        score = entity.score,
                        size = entity.size,
                        sshUrl = entity.sshUrl,
                        stargazersCount = entity.stargazersCount,
                        stargazersUrl = entity.stargazersUrl,
                        statusesUrl = entity.statusesUrl,
                        subscribersUrl = entity.subscribersUrl,
                        subscriptionUrl = entity.subscriptionUrl,
                        svnUrl = entity.svnUrl,
                        tagsUrl = entity.tagsUrl,
                        teamsUrl = entity.teamsUrl,
                        topics = entity.topics,
                        treesUrl = entity.treesUrl,
                        updatedAt = entity.updatedAt,
                        url = entity.url,
                        visibility = entity.visibility,
                        watchers = entity.watchers,
                        watchersCount = entity.watchersCount,
                        webCommitSignoffRequired = entity.webCommitSignoffRequired
                    )
                }

                // Once the mapping is done, set the result to _fetchRepo
                _fetchRepo.value = Resource.Success(mappedList)
                _isLoading.value = false // Set loading to false after data is fetched

            } catch (e: Exception) {
                // Handle any exceptions during the API call
                _fetchRepo.value = Resource.Error(e.message ?: "Failed to fetch data")
                _isLoading.value = false
            }
        }
    }
}




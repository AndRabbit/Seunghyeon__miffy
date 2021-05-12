package org.sopt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.databinding.FragmentRepositoryListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RepositoryListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RepositoryListFragment : Fragment() {
    private var _binding: FragmentRepositoryListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")
    private lateinit var repositoryListAdapter: RepositoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. 우리가 사용할 어댑터의 초기 값 입력
        repositoryListAdapter = RepositoryListAdapter()

        // 2. RecyclerView의 어댑터를 우리가 만든 어댑터로 만들어준다.
        binding.rcvRepositoryList.adapter = repositoryListAdapter

        repositoryListAdapter.repoList.addAll(
            listOf<RepositoryInfo>(
                RepositoryInfo(
                    repoName = "seminar1",
                    repoInfo = "assignment of seminar1",
                    repoLang = "Kotlin"
                ),
                RepositoryInfo(
                    repoName = "seminar2",
                    repoInfo = "assignment of seminar2",
                    repoLang = "Kotlin"
                ),
                RepositoryInfo(
                    repoName = "web project",
                    repoInfo = "assignment of 'Internet Programming'",
                    repoLang = "HTML"
                ),
                RepositoryInfo(
                    repoName = "database project",
                    repoInfo = "assignment of 'Database'",
                    repoLang = "Java"
                ),
                RepositoryInfo(
                    repoName = "Algorithm",
                    repoInfo = "Algorithm study",
                    repoLang = "C++"
                )
            )
        )

        // adapter에 모든 데이터가 변했으니 다시 그려달라고 알려주기
        repositoryListAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
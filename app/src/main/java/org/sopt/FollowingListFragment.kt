package org.sopt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.databinding.FragmentFollowingListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FollowingListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowingListFragment : Fragment() {
    private var _binding: FragmentFollowingListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기위해 binding이 초기화되지 않았습니다.")
    private lateinit var followingListAdapeter: FollowingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 1. 우리가 사용할 어댑터의 초기 값을 넣어줍시다!
        followingListAdapeter = FollowingListAdapter()

        // 2. RecyclerView에 어댑터를 우리가 만든 어댑터로 만들어줍시다!
        binding.rcvFollowingList.adapter = followingListAdapeter

        followingListAdapeter.userList.addAll(
            listOf<FollowingUserInfo>(
                FollowingUserInfo(
                    userImage="지금은 빈 칸!",
                    userName = "한승현1"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현2"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현3"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현4"
                ),
                FollowingUserInfo(
                    userImage="지금은 빈 칸!",
                    userName = "한승현5"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현6"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현7"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현8"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현9"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈 칸!",
                    userName = "한승현10"
                )
            )
        )

        // adapter에 모든 데이터가 변했으니 다시 그려달라고 알려주기
        followingListAdapeter.notifyDataSetChanged()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

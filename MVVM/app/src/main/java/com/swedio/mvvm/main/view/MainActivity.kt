package com.swedio.mvvm.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.swedio.mvvm.R
import com.swedio.mvvm.databinding.ActivityMainBinding
import com.swedio.mvvm.main.viewModel.MainViewModel

/**
 * 블로그 게재 mvvm 예제 소스
 *
 * 탭 레이아웃 3개 - APT, 오피스텔, 무순위
 *
 * - 각기 탭 별로 20개씩 호출 -> 페이징 구현
 * - 아이템 상세 화면 이동 -> 상세화면 구현 -> 상세화면에서 이 정보 저장하기 기능
 *
 * mvvm 패턴을 위한 google aac 사용(viewmodel, livedata)
 * 상세정보 이미지 호출 : glide,
 * api 통신 : retrofit + rxkotlin
 * 내부 db 저장 : realm db
 * 모듈 테스트 : koin -> hilt
 *
 *
 * 탭 1) 아파트 청약 리스트 조회 : /ApplyhomeInfoDetailSvc/v1/getAPTLttotPblancDetail
 * 탭 2) 오피스텔 청약 리스트 조회 : /ApplyhomeInfoDetailSvc/v1/getUrbtyOfctlLttotPblancDetail
 * 탭 3) 무순위 청약 리스트 조회 : /ApplyhomeInfoDetailSvc/v1/getRemndrLttotPblancDetail
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { ViewModelProvider(this, MainViewModel.Factory(application)).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding?>(this, R.layout.activity_main).apply {
            model = viewModel
            lifecycleOwner = this@MainActivity
        }

        initView()

    }

    private fun initView() {
        binding.rvCyList.apply {
            adapter = CyListAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)

        }
    }
}
package com.swedio.bindingadapter.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swedio.bindingadapter.R
import com.swedio.bindingadapter.adapter.CyListAdapter
import com.swedio.openapiproject.network.responseDTO.AptItem

object BindingAdapterUtils {

    /**
     * glide 라이브러리를 이용한 맞춤 메소드 설정
     * : imageUrl, error 2개 값이 모두 할당되어야 사용한다. (requireAll = true)
     */
    @JvmStatic
    @BindingAdapter("binding:imageUrl", "binding:error")
    fun loadImage(imageView: ImageView, imageUrl: String?, errorDrawable: Drawable?) {
        if (imageUrl == null) {
            return

        } // end if

        Glide.with(imageView).load(imageUrl).error(errorDrawable).into(imageView)

    }

    /**
     * glide 라이브러리를 이용한 맞춤 메소드 설정
     * : imageUrl, error 2개 값 중에 1개 값이라도 들어온다면 사용된다. (requireAll = false)
     */
    @JvmStatic
    @BindingAdapter(value = ["binding:imageUrl", "binding:placeHolder"], requireAll = false)
    fun loadImageRequireNonAll(imageView: ImageView, imageUrl: String?, placeHolder: Drawable?) {
        if (imageUrl == null) {
            // 이미지 url이 없다. placeHolder만 들어왔다.
            imageView.setImageDrawable(placeHolder)

        } else {
            // 이미지 url은 있다. 단, placeHolder가 없을 수도 있다. (둘 다 들어올 경우도 있다.)
            Glide.with(imageView.context).load(imageUrl).placeholder(placeHolder).error(placeHolder).into(imageView)

        } // end if

    }

    /**
     * (맞춤 로직 예제 사용)
     * 텍스트 색상 분기 처리
     */
    @JvmStatic
    @BindingAdapter("binding:effect_text")
    fun setEffectText(view: TextView, txt: String?) {
        val txt = txt ?: return

        if (txt.startsWith("a")) {
            view.setTextColor(view.context.getColor(R.color.purple_700))

        } else {
            view.setTextColor(view.context.getColor(R.color.teal_700))

        } // end if

        view.text = txt

    }

    @JvmStatic
    @BindingAdapter("binding:bind_list")
    fun setBindList(recyclerView: RecyclerView, list: MutableList<AptItem>?) {
        val cyList = list ?: return
        val cyListAdapter = recyclerView.adapter as? CyListAdapter ?: return

        cyListAdapter.setAptListItem(cyList)

    }


}

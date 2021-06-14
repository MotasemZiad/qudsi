package com.iug.qudsiapp.ui.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.iug.qudsiapp.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    private var mPlayer: SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    private val videoURL =
        "https://firebasestorage.googleapis.com/v0/b/jerusalem-bf00b.appspot.com/o/video%2F%D8%AA%D8%A7%D8%B1%D9%8A%D8%AE%20%D8%A7%D9%84%D9%82%D8%AF%D8%B3.mp4?alt=media&token=555e4394-7339-4287-952d-1037cb0c3c7f"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initPlayer(){
        mPlayer = SimpleExoPlayer.Builder(requireContext()).build()
        // Bind the player to the view.
        binding.playerView.player = mPlayer
        mPlayer!!.playWhenReady = true
        mPlayer!!.seekTo(currentWindow, playbackPosition)
        mPlayer!!.prepare(buildMediaSource(), false, false)
    }

    private fun releasePlayer() {
        if (mPlayer == null) {
            return
        }
        playWhenReady = mPlayer!!.playWhenReady
        playbackPosition = mPlayer!!.currentPosition
        currentWindow = mPlayer!!.currentWindowIndex
        mPlayer!!.release()
        mPlayer = null
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT < 24 || mPlayer == null) {
            initPlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun buildMediaSource(): MediaSource {
        val uri = Uri.parse(videoURL)
        val factory: DataSource.Factory = DefaultDataSourceFactory(requireContext(), "exoplayer-codelab")
        return ProgressiveMediaSource.Factory(factory).createMediaSource(uri)
    }

}
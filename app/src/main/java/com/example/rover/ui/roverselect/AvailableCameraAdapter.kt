package com.example.rover.ui.roverselect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rover.databinding.ItemRoverCameraBinding
import com.example.rover.models.Camera

class AvailableCameraAdapter(private val onItemClicked: (String) -> Unit) :
    RecyclerView.Adapter<AvailableCameraAdapter.CameraHolder>() {

    private var cameras: List<Camera> = arrayListOf()

    fun addCameras(cameras: List<Camera>) {
        this.cameras = cameras
        notifyDataSetChanged()
    }

    class CameraHolder(private val binding: ItemRoverCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(camera: Camera, onItemClicked: (String) -> Unit) {
            binding.tvCameraName.text = camera.name
            Glide.with(binding.ivCamera.context).load(camera.image).into(binding.ivCamera)

            binding.rootLayout.setOnClickListener {
                onItemClicked(camera.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraHolder {

        val binding =
            ItemRoverCameraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CameraHolder(binding)
    }

    override fun getItemCount(): Int = cameras.size

    override fun onBindViewHolder(holder: CameraHolder, position: Int) {
        holder.bindData(cameras[position], onItemClicked)
    }
}
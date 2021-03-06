package com.epizy.ankurdhuriya.filemanager.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epizy.ankurdhuriya.filemanager.model.MediaFileListModel;
import com.epizy.ankurdhuriya.filemanager.R;

import java.io.File;
import java.util.List;

/*
 * Created by ankur on 23/06/18.
 */

public class ImagesListAdapter extends RecyclerView.Adapter<ImagesListAdapter.MyViewHolder> {
    private List<MediaFileListModel> mediaFileListModels;
    final int THUMB_SIZE = 64;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView lblFileName,lblFileSize,lblFileCreated;
        public ImageView imgItemIcon;

        public MyViewHolder(View view) {
            super(view);
            lblFileName = (TextView) view.findViewById(R.id.file_name);
            lblFileCreated= (TextView) view.findViewById(R.id.file_created);
            imgItemIcon = (ImageView) view.findViewById(R.id.icon);
            lblFileSize= (TextView) view.findViewById(R.id.file_size);
        }
    }

    public ImagesListAdapter(List<MediaFileListModel> mediaFileListModels) {
        this.mediaFileListModels = mediaFileListModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.images_list_item_view, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        MediaFileListModel mediaFileListModel = mediaFileListModels.get(position);
        holder.lblFileName.setText(mediaFileListModel.getFileName());
        holder.lblFileSize.setText(mediaFileListModel.getFileSize());
        holder.lblFileCreated.setText(mediaFileListModel.getFileCreatedTime().substring(0,19));
        File imgFile = new File(mediaFileListModel.getFilePath());
        if (imgFile.exists()) {
            Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile( mediaFileListModel.getFilePath()),
                    THUMB_SIZE, THUMB_SIZE);
            holder.imgItemIcon.setImageBitmap(ThumbImage);
        }
    }

    @Override
    public int getItemCount() {
        return mediaFileListModels.size();
    }
}

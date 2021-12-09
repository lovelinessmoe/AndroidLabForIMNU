package xyz.javaee.myapplication.lab9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

import xyz.javaee.myapplication.R;

public class ImgAdapter extends ArrayAdapter {
    private int resourceId;

    /**
     * 产品列表的构造方法
     *
     * @param context            上下文对象
     * @param textViewResourceId 对应单个item的样式
     * @param objects            要展示的数据
     */
    public ImgAdapter(Context context, int textViewResourceId, List<ImgEntity> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    /**
     * @param position    对应item视图
     * @param convertView 一个旧的item元素
     * @param parent
     * @return 构建出来的新元素
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ImgEntity imgEntity = (ImgEntity) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        TextView message = view.findViewById(R.id.message);
        message.setText(imgEntity.getMessage());

        SmartImageView img = view.findViewById(R.id.img);
        img.setImageUrl(imgEntity.getImg());

        return view;
    }

}

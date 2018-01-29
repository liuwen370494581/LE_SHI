package star.liuwen.com.le_shi.Adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.Model.MySection;
import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/24 16:12
 * desc   :
 */
public class BravhAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public BravhAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.tv_title, item.header);
        helper.addOnClickListener(R.id.tv_more);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        CoverModel coverModel = item.t;

    }
}

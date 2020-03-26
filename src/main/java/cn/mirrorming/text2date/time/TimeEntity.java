package cn.mirrorming.text2date.time;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class TimeEntity {
    private String original;
    private Date value;
    private int offset;
    private Cycle cycle;
    private boolean isDateOnly;
    private boolean isStart;
    private boolean isEnd;

    public TimeEntity(String original, int offset) {
        this.original = original;
        this.offset = offset;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        SimpleDateFormat timeSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
        dateSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).
                append("offset", offset)
                .append("original", original)
                .append("cycle", cycle)
                .append("isDateOnly", isDateOnly)
                .append("isStart", isStart)
                .append("isEnd", isEnd)
                .append("value", value != null ? (isDateOnly ?
                        dateSdf.format(value) :
                        timeSdf.format(value)) : value).toString();
    }

    public boolean isDateOnly() {
        return isDateOnly;
    }

    public void setDateOnly(boolean isDateOnly) {
        this.isDateOnly = isDateOnly;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean isStart) {
        this.isStart = isStart;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
}

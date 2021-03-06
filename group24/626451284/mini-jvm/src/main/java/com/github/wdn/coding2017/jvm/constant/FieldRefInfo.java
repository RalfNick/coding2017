package com.github.wdn.coding2017.jvm.constant;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class FieldRefInfo extends ConstantInfo {
    private int classInfoIndex;
    private int nameAndTypeIndex;

    public FieldRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int getType() {
        return FIELD_INFO;
    }

    @Override
    public String getValue() {
        return getConstantPool().getConstantInfo(classInfoIndex).getValue()+getConstantPool().getConstantInfo(nameAndTypeIndex).getValue();
    }

    public int getClassInfoIndex() {
        return classInfoIndex;
    }

    public void setClassInfoIndex(int classInfoIndex) {
        this.classInfoIndex = classInfoIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(int nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}

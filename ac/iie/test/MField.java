package cn.ac.iie.test;

import lombok.Data;

/**
 * @author zhangzhanqi
 * @version 1.0
 * @date 2019-6-19 15:34
 */

@Data
public class MField {

    private String pName;

    private String pType;

    private String pValue;

    private String cName;

    private String cType;

    public static void main(String[] args) {
        MField mField = new MField();
        mField.getCName();
    }

}

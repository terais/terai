package terai.logic.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import terai.dto.TeraiDto;
import terai.logic.TeraiLogic;
import terai.mapper.TeraiMapper;
/**
 * implements TeraiLogic.
 * @author terai. 2019/06/10.
 */
@Component
public class TeraiLogicImpl implements TeraiLogic {
    /**
     * TeraiMapper.
     */
    @Autowired
    private TeraiMapper teraiMapper;

    @Override
    public TeraiDto getDirNameList(String path) {
        /**
         * TODO 本当はdir内のschemaDir一覧を取得してfxではlistで表示したい.
         */
        return null;
    }
    @Override
    public TeraiDto getFileNameList(String path, String type) {
        String extension = "";
        if (type.equals("CREATE")) {
            extension = ".*.sql";
        } else {
            extension = ".*Const.sql";
        }
        File file = new File(path);
        File files[] = file.listFiles();
        TeraiDto getFileNameDto = new TeraiDto();
        if (files != null) {
            getFileNameDto.setErrorFlag(false);
            ArrayList<String> target = new ArrayList<String>();
            for (int i=0; i<files.length; i++) {
                if (files[i].toString().matches(extension)) {
                    target.add(files[i].toString());
                }
            }
            getFileNameDto.setNameList(target);
        } else {
            getFileNameDto.setErrorFlag(false);
        }
        return getFileNameDto;
    }
    @Override
    public int getQueryContents(ArrayList<String> path,
        String schema, String type)
        throws IOException {
        int resultCode = 0;
        String fs = "";
        for (String target : path) {
            File f = new File(target);
            byte[] data = new byte[(int)f.length()];
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(f));
            bis.read(data);
            bis.close();
            fs += new String(data, "utf-8");
        }
        if (type.equals("CREATE")) {
            resultCode = this.teraiMapper.dropSchema(schema);
            if (resultCode > 0) {
                resultCode = this.teraiMapper.createTable(fs);
            }
        } else {
            resultCode = this.teraiMapper.insertConst(fs);
        }
        return resultCode;
    }
}

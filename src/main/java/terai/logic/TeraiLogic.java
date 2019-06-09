package terai.logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import terai.dto.TeraiDto;
/**
 * TeraiLogic.
 * @author terai. 2019/06/10.
 */
public interface TeraiLogic {
    /**
     * get dir name list.
     * @param path schema parent path.
     * @return getDirNameDto dir name list.
     */
	TeraiDto getDirNameList(String path);
    /**
     * get query file name list.
     * @param path query file parent path.
     * @param type event type.
     * @return getfileNameDto file name list.
     */
    TeraiDto getFileNameList(
        String path, String type);
    /**
     * get query name list.
     * @param path query parent path.
     * @param schema schema.
     * @param type event type.
     * @return resultCode result.
     * @throws FileNotFoundException exception.
     * @throws IOException exception.
     */
    int getQueryContents(ArrayList<String> path,
            String schema, String type)
        throws FileNotFoundException, IOException;
}

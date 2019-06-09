package terai.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * get query file list.
 * get schema dir list.
 * @author terai. 2019/06/10.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeraiDto {
    /**
     * error flag.
     */
    private Boolean errorFlag;
    /**
     * query file list.
     * schema dir list.
     */
    private ArrayList<String> nameList;

}

/**
 * Author: Stefano Ghio
 * Version: 1.0.0.FINAL
 * BW Version: 6.2.1-HF3
 */

package com.tibco.bw.compress.palette.compress.runtime;

import com.tibco.neo.localized.BundleMessage;
import com.tibco.neo.localized.MessageBundle;

public class RuntimeMessageBundle extends MessageBundle 
{

    // Following member is accessed by MessageBundle.initializeMessages, do not remove!
    static public final String BUNDLE_NAME = "com.tibco.bw.compress.palette.compress.runtime.Resources"; //$NON-NLS-1$

    static {
        MessageBundle.initializeMessages(RuntimeMessageBundle.class);
    }
    public static BundleMessage DEBUG_PLUGIN_ACTIVITY_INPUT;
    public static BundleMessage DEBUG_PLUGIN_ACTIVITY_OUTPUT;
    public static BundleMessage ERROR_OCCURED_RETRIEVE_RESULT;
    public static BundleMessage ERROR_OCCURED_INVOKE_EXECUTE_METHOD;
    
    //custom messages - debug
    public static BundleMessage DEBUG_ZIP_ACTIVITY_INPUT;
    public static BundleMessage DEBUG_ADD_ZIP_ENTRY;
    public static BundleMessage DEBUG_CREATE_DIR;
    public static BundleMessage DEBUG_BACKUP_EXISTING_FILE;
    public static BundleMessage DEBUG_DELETE_BACKUP;
    public static BundleMessage DEBUG_UNZIP_ACTIVITY_INPUT;
    public static BundleMessage DEBUG_EXTRACT_ITEM;
    public static BundleMessage DEBUG_GZ_DEFLATE_ACTIVITY_INPUT;
    public static BundleMessage DEBUG_GZ_INFLATE_ACTIVITY_INPUT;
    public static BundleMessage DEBUG_TAR_ACTIVITY_INPUT;
    public static BundleMessage DEBUG_ADD_TAR_ENTRY;
    public static BundleMessage DEBUG_UNTAR_ACTIVITY_INPUT;
    //custom messages - warn
    public static BundleMessage WARN_PATH_NOT_EXISTS;
    public static BundleMessage WARN_FILE_ALREADY_EXISTS;
    //custom messages - error
    public static BundleMessage ERROR_ADD_ZIP_ENTRY;
    public static BundleMessage ERROR_FILE_NOT_FOUND;
    public static BundleMessage ERROR_ZIPPING;
    public static BundleMessage ERROR_UNZIPPING;
    public static BundleMessage ERROR_EXTRACT_ENTRY;
    public static BundleMessage ERROR_GZ_DEFLATING;
    public static BundleMessage ERROR_GZ_INFLATING;
    public static BundleMessage ERROR_ADD_TAR_ENTRY;
    public static BundleMessage ERROR_TARRING;
    public static BundleMessage ERROR_UNTARRING;
    //custom messages - trace
    public static BundleMessage TRACE_ZIP_ACTIVITY_START;
    public static BundleMessage TRACE_ZIPPING;
    public static BundleMessage TRACE_ZIP_ACTIVITY_END;
    public static BundleMessage TRACE_UNZIP_ACTIVITY_START;
    public static BundleMessage TRACE_OVERWRITE_ITEM;
    public static BundleMessage TRACE_UNZIP_ACTIVITY_END;
    public static BundleMessage TRACE_GZ_DEFLATE_ACTIVITY_START;
    public static BundleMessage TRACE_GZ_DEFLATE_ACTIVITY_END;
    public static BundleMessage TRACE_GZ_INFLATE_ACTIVITY_START;
    public static BundleMessage TRACE_GZ_INFLATE_ACTIVITY_END;
    public static BundleMessage TRACE_DEFLATING;
    public static BundleMessage TRACE_TAR_ACTIVITY_START;
    public static BundleMessage TRACE_TARRING;
    public static BundleMessage TRACE_TAR_ACTIVITY_END;
    public static BundleMessage TRACE_UNTAR_ACTIVITY_START;
    public static BundleMessage TRACE_UNTAR_ACTIVITY_END;
}

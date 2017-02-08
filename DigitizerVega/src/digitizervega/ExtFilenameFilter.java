/*
 * DigitizerVega: A Digitizer code 
 * Developed by Abhijit Bhattacharyya,
 * Nuclear Data Physics Centre of India (NDPCI),
 *  Bhabha Atomic Research Centre, Mumbai, 400 085, INDIA
 */
package digitizervega;

import java.io.*;
import java.util.*;

/**
 *
 * @author vega
 */
public class ExtFilenameFilter implements FilenameFilter, FileFilter {

    private List<String> filters = null;
    private HashMap<String, ExtFilenameFilter> nameFilters = null;
    private String description = null;
    private String fullDescription = null;
    private boolean useExtensionsInDescription = true;

    public ExtFilenameFilter() {
        this((String) null, (String) null);
    }

    public ExtFilenameFilter(String extension) {
        this(extension, null);
    }

    public ExtFilenameFilter(String extension, String description) {
        this(new String[]{extension}, description);
    }

    public ExtFilenameFilter(String[] filters) {
        this(filters, null);
    }

    public ExtFilenameFilter(String[] filters, String description) {
        this.filters = new ArrayList<String>();
        for (String filter : filters) {
            // add filters one by one
            addExtension(filter);
        }
        setDescription(description);
        nameFilters = new HashMap<String, ExtFilenameFilter>(4);
    }

    @Override
    public boolean accept(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                return true;
            }

            String name = f.getName().toLowerCase();
            if (nameFilters.get(name) != null) {
                return true;
            }

            return extensionMatch(name);
        }
        return false;
    }

    @Override
    public boolean accept(File dir, String name) {
        if (dir != null && name != null) {

            if (nameFilters.get(name) != null) {
                return true;
            }
            return extensionMatch(name);
        }
        return false;
    }

    private boolean extensionMatch(String fileName) {
        if (filters.isEmpty()) {
            return true;
        }
        for (String ext : filters) {
            if (fileName.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    public static String getExtension(String name) {
        if (name != null) {
            int i = name.indexOf('.');
            if (i > 0 && i < name.length() - 1) {
                return name.substring(i + 1).toLowerCase();
            }
        }
        return null;
    }

    public static String getExtension(File f) {
        if (f != null) {
            String filename = f.getName();
            return getExtension(filename);
        }
        return null;
    }

    public final void addExtension(String extension) {

        if (extension != null && !extension.equals("")) {
            //  Make sure that the extension starts with a ".".
            if (!extension.startsWith(".")) {
                extension = "." + extension;
            }
            //  Store the extension in our database of extensions.
            filters.add(extension.toLowerCase());
        }
        fullDescription = null;
    }

    public void addFilename(String fileName) {
        if (fileName != null && !fileName.equals("")) {
            nameFilters.put(fileName.toLowerCase(), this);
        }
    }

    public void addExtensions(String extensionList) {
        StringTokenizer tokenizer = new StringTokenizer(extensionList, ", \t");
        while (tokenizer.hasMoreTokens()) {
            addExtension(tokenizer.nextToken());
        }
    }

    public String getDescription() {
        if (fullDescription == null) {
            if (description == null || isExtensionListInDescription()) {
                if (description != null) {
                    fullDescription = description;
                }
                fullDescription += " (";
                // build the description from the extension list
                Iterator<String> extensions = filters.iterator();
                if (extensions != null) {
                    fullDescription += extensions.next().substring(1);
                    while (extensions.hasNext()) {
                        fullDescription += ", " + extensions.next().substring(
                                1);
                    }
                }
                fullDescription += ")";
            } else {
                fullDescription = description;
            }
        }
        return fullDescription;
    }

    public final void setDescription(String description) {
        this.description = description;
        fullDescription = null;
    }

    public void setExtensionListInDescription(boolean useExtInDescription) {
        useExtensionsInDescription = useExtInDescription;
        fullDescription = null;
    }

    public boolean isExtensionListInDescription() {
        return useExtensionsInDescription;
    }

}

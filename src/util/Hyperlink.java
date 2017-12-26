package util;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Hyperlink implements Transferable {
	
	private static List<DataFlavor> htmlFlavors = new ArrayList<>(3);

    static {

        try {
            htmlFlavors.add(new DataFlavor("text/html;class=java.lang.String"));
            htmlFlavors.add(new DataFlavor("text/html;class=java.io.Reader"));
            htmlFlavors.add(new DataFlavor("text/html;charset=unicode;class=java.io.InputStream"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    
    private String html;
    
    public Hyperlink(String html){
    	this.html = html;
    }


	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		if (String.class.equals(flavor.getRepresentationClass())) {
            return html;
        } else if (Reader.class.equals(flavor.getRepresentationClass())) {
            return new StringReader(html);
        } else if (InputStream.class.equals(flavor.getRepresentationClass())) {
            return new StringBufferInputStream(html);
        }
        throw new UnsupportedFlavorException(flavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (DataFlavor[]) htmlFlavors.toArray(new DataFlavor[htmlFlavors.size()]);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return htmlFlavors.contains(flavor);
	}

}

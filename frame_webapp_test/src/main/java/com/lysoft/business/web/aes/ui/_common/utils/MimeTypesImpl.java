/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.lysoft.business.web.aes.ui._common.utils;

import javax.activation.MimetypesFileTypeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <a href="MimeTypesImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 *
 */
public class MimeTypesImpl implements MimeTypes {
	private static Logger logger = LoggerFactory.getLogger(MimeTypesImpl.class);
	public MimeTypesImpl() {
		_mimeTypes = new MimetypesFileTypeMap();
		_mimeTypes.addMimeTypes("application/msword doc");
		_mimeTypes.addMimeTypes("application/vnd.ms-excel xls");
		_mimeTypes.addMimeTypes("application/pdf pdf");
		_mimeTypes.addMimeTypes("text/richtext rtx");
		_mimeTypes.addMimeTypes("text/csv csv");
		_mimeTypes.addMimeTypes("text/tab-separated-values tsv tab");
		_mimeTypes.addMimeTypes("application/x-vnd.oasis.opendocument.spreadsheet ods");
		_mimeTypes.addMimeTypes("application/vnd.oasis.opendocument.text odt");
		_mimeTypes.addMimeTypes("application/vnd.ms-powerpoint ppt pps pot");
		_mimeTypes.addMimeTypes("application/x-shockwave-flash swf");
		_mimeTypes.addMimeTypes("application/vnd.openxmlformats-officedocument."
          + "wordprocessingml.document docx");
		_mimeTypes.addMimeTypes("application/vnd.openxmlformats-officedocument."
          + "spreadsheetml.sheet xlsx");
		_mimeTypes.addMimeTypes("audio/mpeg mp3 mpeg3");
		_mimeTypes.addMimeTypes("image/png png");
		_mimeTypes.addMimeTypes("application/zip zip");
		_mimeTypes.addMimeTypes("application/x-tar tar");
		_mimeTypes.addMimeTypes("video/quicktime qt mov moov");
		_mimeTypes.addMimeTypes("video/mpeg mpeg mpg mpe mpv vbs mpegv");
		_mimeTypes.addMimeTypes("video/msvideo avi");
	}
	
	public String getContentType(String fileName) {
		String contentType = _mimeTypes.getContentType(fileName);

		if (logger.isDebugEnabled()) {
			logger.debug(
				"Content type " + contentType + " returned for file name " +
					fileName);
		}

		return contentType;
	}


	private MimetypesFileTypeMap _mimeTypes;

}
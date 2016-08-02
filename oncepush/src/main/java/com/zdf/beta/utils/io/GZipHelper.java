/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved.
 */


package com.zdf.beta.utils.io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


 /**
  * GZip压缩工具类
  *
  * @since jdk1.6
  * @version $Id: GZipHelper.java 3279 2014-08-06 03:38:42Z xiaoying $
  */
public class GZipHelper {
    private static int bufSize = 1024;

    /**
     * 压缩字节数组并返回压缩后的字节数组
     *
     * @param bytes 要压缩的字节数组
     * @throws IOUtilException
     */
    public static byte[] compressToBytes(byte[] bytes) throws IOUtilException {
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            try {
                compressToStream(bytes, outStream);
            } finally {
                outStream.close();
            }
            return outStream.toByteArray();
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩字符串并返回压缩后的字节数组
     *
     * @param src 要压缩的字符串
     * @throws IOUtilException
     */
    public static byte[] compressToBytes(String src) throws IOUtilException {
        return compressToBytes(src.getBytes());
    }

    /**
     * 压缩字符串并返回压缩后的字节数组
     *
     * @param src         要压缩的字符串
     * @param charsetName 压缩前要把字符串转换为何种字符集的编码
     * @throws IOUtilException
     */
    public static byte[] compressToBytes(String src, String charsetName) throws IOUtilException {
        try {
            if (charsetName == null)
                return compressToBytes(src.getBytes());
            else {
                return compressToBytes(src.getBytes(charsetName));
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩文件并返回压缩后的字节数组
     *
     * @param fileName 要压缩的文件名
     * @throws IOUtilException
     */
    public static byte[] compressFileToBytes(String fileName) throws IOUtilException {
        try {
            FileInputStream inStream = new FileInputStream(fileName);
            try {
                return compressToBytes(inStream);
            } finally {
                inStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩输入流并返回压缩后的字节数组
     *
     * @param inStream 输入流
     * @return
     * @throws IOUtilException
     */
    public static byte[] compressToBytes(InputStream inStream) throws IOUtilException {
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            try {
                compressToStream(inStream, outStream);
            } finally {
                outStream.close();
            }
            return outStream.toByteArray();
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩字节数组并把压缩结果写入输出流
     *
     * @param bytes     要压缩的字节数组
     * @param outStream 写入压缩结果的输出流
     * @throws IOUtilException
     */
    public static void compressToStream(byte[] bytes, OutputStream outStream) throws IOUtilException {
        try {
            GZIPOutputStream gzipOut = new GZIPOutputStream(outStream);
            try {
                gzipOut.write(bytes);
                gzipOut.finish();
            } finally {
                gzipOut.close();
            }
        } catch (Throwable e) {
            throw new IOUtilException(e);
        }
    }

    /**
     * 压缩字符串并把压缩结果写入输出流
     *
     * @param src       要压缩的字符串
     * @param outStream 写入压缩结果的输出流
     * @throws IOUtilException
     */
    public static void compressToStream(String src, OutputStream outStream) throws IOUtilException {
        compressToStream(src.getBytes(), outStream);
    }

    /**
     * 压缩字符串并把压缩结果写入输出流
     *
     * @param src         要压缩的字符串
     * @param charsetName 压缩前要把字符串转换为何种字符集的编码
     * @param outStream   写入压缩结果的输出流
     * @throws IOUtilException
     */
    public static void compressToStream(String src, String charsetName, OutputStream outStream) throws IOUtilException {
        try {
            if (charsetName == null)
                compressToStream(src.getBytes(), outStream);
            else
                compressToStream(src.getBytes(charsetName), outStream);
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩输入流并把压缩结果写入输出流
     *
     * @param inStream  要压缩的输入流
     * @param outStream 写入压缩结果的输出流
     * @throws IOUtilException
     */
    public static void compressToStream(InputStream inStream, OutputStream outStream) throws IOUtilException {
        try {
            GZIPOutputStream gzipOut = new GZIPOutputStream(outStream);
            try {
                byte[] buf = new byte[bufSize];
                int len;

                while ((len = inStream.read(buf)) >= 0)
                    gzipOut.write(buf, 0, len);

                gzipOut.finish();
            } finally {
                gzipOut.close();
            }
        } catch (Throwable e) {
            throw new IOUtilException(e);
        }
    }

    /**
     * 压缩文件并把压缩结果写入输出流
     *
     * @param fileName  要压缩的文件名
     * @param outStream 写入压缩结果的输出流
     * @throws IOUtilException
     */
    public static void compressFileToStream(String fileName, OutputStream outStream) throws IOUtilException {
        try {
            FileInputStream inStream = new FileInputStream(fileName);
            try {
                compressToStream(inStream, outStream);
            } finally {
                inStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩字节数组并生成文件
     *
     * @param bytes    要压缩的字节数组
     * @param fileName 要生成的文件名
     * @throws IOUtilException
     */
    public static void compressToFile(byte[] bytes, String fileName) throws IOUtilException {
        try {
            FileOutputStream outStream = new FileOutputStream(fileName);
            try {
                compressToStream(bytes, outStream);
            } finally {
                outStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩字符串并生成文件
     *
     * @param src      要压缩的字符串
     * @param fileName 要生成的文件名
     * @throws IOUtilException
     */
    public static void compressToFile(String src, String fileName) throws IOUtilException {
        compressToFile(src.getBytes(), fileName);
    }

    /**
     * 压缩字符串并生成文件
     *
     * @param src         要压缩的字符串
     * @param charsetName 压缩前要把字符串转换为何种字符集的编码
     * @param fileName    要生成的文件名
     * @throws IOUtilException
     */
    public static void compressToFile(String src, String charsetName, String fileName) throws IOUtilException {
        try {
            if (charsetName == null)
                compressToFile(src.getBytes(), fileName);
            else
                compressToFile(src.getBytes(charsetName), fileName);
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩输入流并生成文件
     *
     * @param inStream 要压缩的输入流
     * @param fileName 要生成的文件名
     * @throws IOUtilException
     */
    public static void compressToFile(InputStream inStream, String fileName) throws IOUtilException {
        try {
            FileOutputStream outStream = new FileOutputStream(fileName);
            try {
                compressToStream(inStream, outStream);
            } finally {
                outStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 压缩文件并生成另一个文件
     *
     * @param fileName    要压缩的文件名
     * @param outFileName 要生成的文件名
     * @throws IOUtilException
     */
    public static void compressFileToFile(String fileName, String outFileName) throws IOUtilException {
        try {
            FileInputStream inStream = new FileInputStream(fileName);
            try {
                compressToFile(inStream, outFileName);
            } finally {
                inStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩字节数组并返回原始字节数组
     *
     * @param bytes 要解压缩的字节数组
     * @throws IOUtilException
     */
    public static byte[] decompressToBytes(byte[] bytes) throws IOUtilException {
        try {
            ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
            try {
                return decompressToBytes(inStream);
            } finally {
                inStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩输入流并返回原始字节数组
     *
     * @param inStream 要解压缩的输入流
     * @throws IOUtilException
     */
    public static byte[] decompressToBytes(InputStream inStream) throws IOUtilException {
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            try {
                decompressToStream(inStream, outStream);
            } finally {
                outStream.close();
            }
            return outStream.toByteArray();
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩字节数组并返回原始字符串
     *
     * @param bytes 要解压缩的字节数组
     * @throws IOUtilException
     */
    public static String decompressToString(byte[] bytes) throws  IOUtilException  {
        return decompressToString(bytes, null);
    }

    /**
     * 解压缩输入流并返回原始字符串
     *
     * @param inStream 要解压缩的输入流
     * @throws IOUtilException
     */
    public static String decompressToString(InputStream inStream) throws IOUtilException {
        return decompressToString(inStream, null);
    }

    /**
     * 解压缩字节数组并返回原始字符串
     *
     * @param bytes       要解压缩的字节数组
     * @param charsetName 解压缩得到的结果以何种字符集转换为字符串
     * @throws IOUtilException
     */
    public static String decompressToString(byte[] bytes, String charsetName) throws IOUtilException {
        try {
            ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
            try {
                return decompressToString(inStream, charsetName);
            } finally {
                inStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩输入流并返回原始字符串
     *
     * @param inStream    要解压缩的输入流
     * @param charsetName 解压缩得到的结果以何种字符集转换为字符串
     * @throws IOUtilException
     */
    public static String decompressToString(InputStream inStream, String charsetName) throws IOUtilException {
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            try {
                decompressToStream(inStream, outStream);
            } finally {
                outStream.close();
            }

            if (charsetName == null)
                return outStream.toString();
            else
                return outStream.toString(charsetName);
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩字节数组并写入输出流
     *
     * @param bytes     要解压缩的字节数组
     * @param outStream 解压缩结果所要写入的输出流
     * @throws IOUtilException
     */
    public static void decompressToStream(byte[] bytes, OutputStream outStream) throws IOUtilException {
        try {
            ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
            try {
                decompressToStream(inStream, outStream);
            } finally {
                inStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩输入流并写入输出流
     *
     * @param inStream  要解压缩的输入流
     * @param outStream 解压缩结果所要写入的输出流
     * @throws IOUtilException
     */
    public static void decompressToStream(InputStream inStream, OutputStream outStream) throws IOUtilException {
        try {
            GZIPInputStream gzipIn = new GZIPInputStream(inStream);
            try {
                byte buf[] = new byte[bufSize];
                int len;
                while ((len = gzipIn.read(buf)) >= 0)
                    outStream.write(buf, 0, len);
            } finally {
                gzipIn.close();
            }
        } catch (Throwable e) {
            throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩字节数组并生成一个文件
     *
     * @param bytes    要解压缩的字节数组
     * @param fileName 要生成的文件名
     * @throws IOUtilException
     */
    public static void decompressToFile(byte[] bytes, String fileName) throws IOUtilException {
        try {
            ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
            try {
                decompressToFile(inStream, fileName);
            } finally {
                inStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

    /**
     * 解压缩输入流并生成一个文件
     *
     * @param inStream 要解压缩的输入流
     * @param fileName 要生成的文件名
     * @throws IOUtilException
     */
    public static void decompressToFile(InputStream inStream, String fileName) throws IOUtilException {
        try {
            FileOutputStream outStream = new FileOutputStream(fileName);
            try {
                decompressToStream(inStream, outStream);
            } finally {
                outStream.close();
            }
        } catch (Throwable e) {
            if (e instanceof IOUtilException)
                throw (IOUtilException) e;
            else
                throw new IOUtilException(e);
        }
    }

}

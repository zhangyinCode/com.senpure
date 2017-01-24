package com.senpure.base.i18n;


import com.senpure.AppContext;
import com.senpure.base.util.Pinyin;
import com.senpure.base.util.StringUtil;

import java.io.*;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;

public class I18NGenerator {

	//private static final String defaultBaseName = "i18n/result/result";
	private static final String defaultBaseName = "casion/language";
	private static final String textPath = "/E:/i18n";
	private static Locale locale = new Locale("zh", "CN");
	//true 表示生成 text文件， false 表示生成properties
	private static boolean toText = true;
	private static boolean toTextKey = false;
	// private static boolean toText = false;
	//如果text没有key值，需要该值座位参照
	private static Locale referLocale = new Locale("zh", "CN");
	//private static Locale referLocale =null;
	public static void generateText() {

		try {

			// System.out.println(ApplicationContext.getRootPath());

			File file = new File(AppContext.getClassRootPath() + defaultBaseName + ".properties");
			Properties pro = new SortProperties();
			pro.load(new FileInputStream(file));
			File save;
			int index = StringUtil.indexOf(defaultBaseName, "/", 1, true);
			if (index > -1) {

				save = new File(textPath, defaultBaseName.substring(index) + ".txt");
			}
			else {
				save = new File(textPath, defaultBaseName + ".txt");
			}
			File temp = new File(save.getParent());
			temp.mkdirs();
			System.out.println(save.createNewFile());
			System.out.println(save.getAbsolutePath());
			Iterator<Object> bs = pro.keySet().iterator();
			FileWriter writer = new FileWriter(save);
			while (bs.hasNext()) {
				Object b = bs.next();
				if(toTextKey) {
					writer.write(b.toString());
					writer.write("=");
					System.out.print(b.toString());
					System.out.print("=");
				}
				writer.write(pro.getProperty(b.toString()));
				writer.write("\r\n");

				System.out.println(pro.getProperty(b.toString()));
				// System.out.println();

			}
			writer.flush();
			writer.close();
			System.out.println("over");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private  static void generateProperties() {

		File text ;
		int index = StringUtil.indexOf(defaultBaseName, "/", 1, true);

		if (index > -1) {

			text = new File(textPath, defaultBaseName.substring(index) + "_" + locale + ".txt");
		}

		else {
			text = new File(textPath, defaultBaseName + "_" + locale+ ".txt");
		}

		try {
			SortProperties props = new SortProperties();

			InputStream inputStream = new FileInputStream(text);
			// new input

			InputStreamReader ir = new InputStreamReader(inputStream, "utf-8");
			BufferedReader reader = new BufferedReader(ir);

			if(referLocale!=null)
			{

				File file = new File(AppContext.getClassRootPath() + defaultBaseName + ".properties");
				Properties pro = new SortProperties();
				pro.load(new FileInputStream(file));


				Iterator<Object> bs = pro.keySet().iterator();
				while (reader.ready()) {
					String line = reader.readLine();
					if (line.startsWith("#")) {
						continue;
					}
					System.out.println(line);
					props.put(bs.next().toString(),line);

				}
			}
			else {
				while (reader.ready()) {
					String line = reader.readLine();
					System.out.println(line);

					if (line.startsWith("#")) {
						continue;
					}

					// System.out.println(line.endsWith("\n"));

					int index2 = line.indexOf("=");
					String key;
					String value;
					if(index2==-1)
					{
						key = Pinyin.toAccount(line)[0];
						value = line;
					}

					else {
						key = line.substring(0, index2);
						value = line.substring(index2 + 1);
					}

					props.put(key, value);
					System.out.print(key);
					// System.out.print("=");
					// System.out.println(value);

				}
			}


			reader.close();
			File save = new File(AppContext.getClassRootPath() + defaultBaseName + "_" + locale + ".properties");

			OutputStream outputStream = new FileOutputStream(save);
			//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
			// FileWriter writer;
			//
			// writer = new FileWriter(save);
			//
			// props.store(writer, "");
			// writer.close();
			//
			//props.put("key", "value1");
			//props.put("key2", " 你好");
			props.store(outputStream, null);
			System.out.println(save.getAbsolutePath());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		if (toText) {
			generateText();
		} else {

			generateProperties();
		}

		// System.out.println("123".substring(-1, 1));

	}

}

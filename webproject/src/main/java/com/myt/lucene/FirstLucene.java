package com.myt.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class FirstLucene {
	
	@Test
	public  void testIndex() throws IOException {
		/**
		 * 第一步，创建Java工程，导入jar包
		 * 第二步，创建一个IndexWriter对象
		 * 		1）指定索引库的存放位置Directory对象
		 * 		2）指定一个分析器，对文档内容进行分析
		 * 第三步，创建Document对象
		 * 第四步，创建Field对象，将field添加到Document对象中
		 * 第五步，使用IndexWriter对象将Document对象写入索引库，此过程进行索引创建，并将索引和document对象写入索引库
		 * 第六步，关闭IndexWriter对象
		 */
		//创建一个IndexWriter对象
		Directory directory = FSDirectory.open(new File("D:\\software\\index"));
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, config);
		//创建document对象
		Document document = new Document();
		//创建field对象，并将field添加到document对象中
		File file = new File("D:\\testLucene");
		File[] listFile = file.listFiles();
		for(File f : listFile) {
			//文件名称
			String file_name = f.getName();
			Field fieldNameField = new TextField("fileName", file_name, Store.YES);
			//文件大小
			long file_size = FileUtils.sizeOf(f);
			Field fileSizeField = new LongField("fileSize", file_size, Store.YES);
			//文件路径
			String file_path = f.getPath();
			Field filePathField = new StoredField("filePath", file_path);
			//文件内容
			String file_content = FileUtils.readFileToString(f);
			Field fieldContentField = new TextField("fileContent", file_content, Store.YES);
			document.add(fieldNameField);
			document.add(fileSizeField);
			document.add(filePathField);
			document.add(fieldContentField);
			indexWriter.addDocument(document);
		}
		indexWriter.close();
		System.out.println(document);
		
	} 
	@Test
	public void search() throws IOException {
		/**
		 * 第一步，创建一个Directory对象，也就是索引库存放的位置
		 * 第二步，创建一个IndexReader对象，需要指定Directory对象
		 * 第三步，创建一个IndexSearcher对象，需要指定IndexReader对象
		 * 第四步，创建一个TermQuery对象，指定查询的域和查询的关键词
		 * 第五步，执行查询
		 */
		Directory directory = FSDirectory.open(new File("D:\\software\\index"));
		IndexReader indexReader = DirectoryReader.open(directory);
		//创建一个IndexSearcher对象，需要指定IndexReader对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		//创建一个TermQuery对象，指定查询的域和查询的关键词
		TermQuery query = new TermQuery(new Term("fileName", "index.txt"));
		//执行查询
		TopDocs topDocs = indexSearcher.search(query,10);
		//返回查询结果
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		System.out.println(scoreDocs.length);
		for(ScoreDoc scoreDoc : scoreDocs) {
			int docId = scoreDoc.doc;
			Document document = indexSearcher.doc(docId);
			//文件名称
			String fileName = document.get("fileName");
			//文件内容
			String fileContent = document.get("fileContent");
			//文件大小
			String fileSize = document.get("fileSize");
			//文件路径
			String filePath = document.get("filePath");
			
			System.out.println(fileName+","+filePath+","+fileSize+","+fileContent);
		}
		indexReader.close();
	}
	
	
}

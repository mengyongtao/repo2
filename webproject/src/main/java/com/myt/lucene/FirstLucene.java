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
		 * ��һ��������Java���̣�����jar��
		 * �ڶ���������һ��IndexWriter����
		 * 		1��ָ��������Ĵ��λ��Directory����
		 * 		2��ָ��һ�������������ĵ����ݽ��з���
		 * ������������Document����
		 * ���Ĳ�������Field���󣬽�field��ӵ�Document������
		 * ���岽��ʹ��IndexWriter����Document����д�������⣬�˹��̽�����������������������document����д��������
		 * ���������ر�IndexWriter����
		 */
		//����һ��IndexWriter����
		Directory directory = FSDirectory.open(new File("D:\\software\\index"));
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, config);
		//����document����
		Document document = new Document();
		//����field���󣬲���field��ӵ�document������
		File file = new File("D:\\testLucene");
		File[] listFile = file.listFiles();
		for(File f : listFile) {
			//�ļ�����
			String file_name = f.getName();
			Field fieldNameField = new TextField("fileName", file_name, Store.YES);
			//�ļ���С
			long file_size = FileUtils.sizeOf(f);
			Field fileSizeField = new LongField("fileSize", file_size, Store.YES);
			//�ļ�·��
			String file_path = f.getPath();
			Field filePathField = new StoredField("filePath", file_path);
			//�ļ�����
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
		 * ��һ��������һ��Directory����Ҳ�����������ŵ�λ��
		 * �ڶ���������һ��IndexReader������Ҫָ��Directory����
		 * ������������һ��IndexSearcher������Ҫָ��IndexReader����
		 * ���Ĳ�������һ��TermQuery����ָ����ѯ����Ͳ�ѯ�Ĺؼ���
		 * ���岽��ִ�в�ѯ
		 */
		Directory directory = FSDirectory.open(new File("D:\\software\\index"));
		IndexReader indexReader = DirectoryReader.open(directory);
		//����һ��IndexSearcher������Ҫָ��IndexReader����
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		//����һ��TermQuery����ָ����ѯ����Ͳ�ѯ�Ĺؼ���
		TermQuery query = new TermQuery(new Term("fileName", "index.txt"));
		//ִ�в�ѯ
		TopDocs topDocs = indexSearcher.search(query,10);
		//���ز�ѯ���
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		System.out.println(scoreDocs.length);
		for(ScoreDoc scoreDoc : scoreDocs) {
			int docId = scoreDoc.doc;
			Document document = indexSearcher.doc(docId);
			//�ļ�����
			String fileName = document.get("fileName");
			//�ļ�����
			String fileContent = document.get("fileContent");
			//�ļ���С
			String fileSize = document.get("fileSize");
			//�ļ�·��
			String filePath = document.get("filePath");
			
			System.out.println(fileName+","+filePath+","+fileSize+","+fileContent);
		}
		indexReader.close();
	}
	
	
}

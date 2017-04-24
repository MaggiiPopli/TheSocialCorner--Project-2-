package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Blog;

@Repository
public class BlogDAOImpl implements BlogDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	/*public boolean insertBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(blog);
		tx.commit();
		sess.close();
		return true;
		}
		catch(Exception ex){
		
			System.out.println("Exception"+ex);
			return false;
		}
		
	}*/
	
	public void insertBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(blog);
		tx.commit();
		sess.close();
		}
		catch(Exception ex){
		
			System.out.println("Exception"+ex);
		
		}
		
	}


	public List<Blog> viewBlog() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from Blog");
		List<Blog> b=q.list();
		session.close();
		return b;
	}


	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			sess.update(blog);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception ex){
			
			System.out.println(ex);
			return false;
		}
		
	}


	public boolean deleteBlog(int blog_id) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			Blog id=sess.get(Blog.class, blog_id);
			sess.delete(id);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception ex){
			System.out.println("Exception"+ex);
		return false;
		}
	}


	public boolean editBlog(int blog_id) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
		
		Transaction tx=sess.beginTransaction();
		Blog b=sess.get(Blog.class, blog_id);
		sess.update(b);
		tx.commit();
		sess.close();
		return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
			
		}
	}


	public Blog getBlogbyId(int blog_id) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Blog id=sess.get(Blog.class, blog_id);
		return id;
	}


	public List<Blog> getBlogbyUsername(String username) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		Query q=sess.createQuery("select * from Blog where username=:username");
		List<Blog> l=q.list();
		return l;
	}

}
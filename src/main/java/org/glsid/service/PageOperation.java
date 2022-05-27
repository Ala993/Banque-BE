package org.glsid.service;


import org.glsid.entites.Operation;

import java.io.Serializable;
import java.util.List;

public class PageOperation implements Serializable{
private List<Operation>operation;
private int page;
private int nombreOperation;
private int totalOperation;
private int totalPages;
public List<Operation> getOperation() {
	return operation;
}
public void setOperation(List<Operation> operation) {
	this.operation = operation;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getNombreOperation() {
	return nombreOperation;
}
public void setNombreOperation(int nombreOperation) {
	this.nombreOperation = nombreOperation;
}
public int getTotalOperation() {
	return totalOperation;
}
public void setTotalOperation(int totalOperation) {
	this.totalOperation = totalOperation;
}
public int getTotalPages() {
	return totalPages;
}
public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}

}

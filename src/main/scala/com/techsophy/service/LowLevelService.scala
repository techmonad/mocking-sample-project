package com.techsophy.service

trait LowLevelService {

  def insert(emp: Employee): Int

  def update(emp: Employee): Int

  def delete(id: Int): Int

  def getById(id: Int): Option[Employee]

  def getAll(): List[Employee]

}


case class Employee(id: Int, name: String)
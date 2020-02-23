package com.techmonad.service

import org.json4s._
import org.json4s.native.{JsonMethods, Serialization}

/**
 * High Level Service for converting scala objects into json and vice-versa
 */
trait HighLevelService {

  implicit val formats = DefaultFormats
  val lowLevelService: LowLevelService

  def createEmployeeFromJson(str: String): Int = {
    val employee = JsonMethods.parse(str).extract[Employee]
    lowLevelService.insert(employee)
  }

  def getAllEmployeeAsJson(): String = {
    val employeeList: List[Employee] = lowLevelService.getAll()
    Serialization.write(employeeList)
  }

}

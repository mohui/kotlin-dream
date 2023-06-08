package com.dream.school.service.impl

import com.dream.school.constant.AREA_LIST
import com.dream.school.dto.AreaDTO
import com.dream.school.service.ExportService
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

@Service
class ExportServiceImpl: ExportService {
    /**
     * 导出excel
     */
    override fun exceptTest() {
        val workbook: Workbook = XSSFWorkbook()

        // 创建工作表对象
        val sheet = workbook.createSheet("地区列表")

        // 创建行对象
        val headerRow = sheet.createRow(0)

        // 创建单元格对象并设置值(创建表头)
        headerRow.createCell(0).setCellValue("地区ID")
        headerRow.createCell(1).setCellValue("地区名称")
        headerRow.createCell(2).setCellValue("上级地区ID")

        // 填充数据行
        var rowIndex = 1
        for (area in AREA_LIST) {
            val dataRow = sheet.createRow(rowIndex++)
            dataRow.createCell(0).setCellValue(area.code)
            dataRow.createCell(1).setCellValue(area.name)
            dataRow.createCell(2).setCellValue(area.parent)
        }

        // 指定导出的相对路径
        val relativePath = "/Users/wanghehui/projects/xzmProjects/kotlin-dream/area_list.xlsx"
        // 获取项目根目录的绝对路径(用不到)
        val projectDir = System.getProperty("user.dir")
        // 构建导出文件的绝对路径(用不到)
        val filePath = File(projectDir, relativePath).absolutePath

        // 导出 Excel 文件
        val fileOut = FileOutputStream(File(relativePath))
        workbook.write(fileOut)
        fileOut.close()

        // 打印完成信息
        println("Excel 导出完成！")
    }

    /**
     * 导入Excel
     */
    override fun importExcel() {
        val filePath = "area_list.xlsx" // Excel 文件路径

        val fileInputStream = FileInputStream(filePath)
        val workbook = XSSFWorkbook(fileInputStream)

        val sheet = workbook.getSheetAt(0) // 获取第一个工作表

        val areaList = mutableListOf<AreaDTO>()

        // 从第二行开始遍历数据行
        for (rowIndex in 1..sheet.lastRowNum) {
            val row = sheet.getRow(rowIndex)

            val idCell = row.getCell(0)
            val nameCell = row.getCell(1)
            val parentIdCell = row.getCell(2)

            val id = idCell.stringCellValue
            val name = nameCell.stringCellValue
            val parentId = parentIdCell.stringCellValue
            // 如果是数字
            // val num = parentIdCell.numericCellValue.toString()

            val area = AreaDTO(code = id, name = name, parent = parentId)
            areaList.add(area)
        }

        // 打印导入的地区列表
        areaList.forEach { area ->
            println("地区ID: ${area.code}, 地区名称: ${area.name}, 上级地区ID: ${area.parent}")
        }

        // 关闭文件输入流和工作簿
        fileInputStream.close()
        workbook.close()
    }

    /**
     * 图片上传
     */
    override fun upload() {
        val imageFile = File("/Users/wanghehui/Desktop/桌面文件/图片/ying.jpg") // 替换为实际图片文件的路径

        val url = URL("http://127.0.0.1:8080/upload") // 替换为实际的上传 URL

        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.doOutput = true

        val boundary = "*****" // 定义分隔符

        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=$boundary")

        val outputStream = DataOutputStream(connection.outputStream)

        outputStream.writeBytes("--$boundary\r\n")
        outputStream.writeBytes("Content-Disposition: form-data; name=\"image\"; filename=\"${imageFile.name}\"\r\n")
        outputStream.writeBytes("Content-Type: image/jpeg\r\n")
        outputStream.writeBytes("\r\n")

        val imageInputStream = FileInputStream(imageFile)
        val buffer = ByteArray(4096)
        var bytesRead: Int
        while (imageInputStream.read(buffer).also { bytesRead = it } != -1) {
            outputStream.write(buffer, 0, bytesRead)
        }

        outputStream.writeBytes("\r\n")
        outputStream.writeBytes("--$boundary--\r\n")
        outputStream.flush()
        outputStream.close()

        val responseCode = connection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // 上传成功
            println("图片上传成功")
        } else {
            // 上传失败
            println("图片上传失败，错误码: $responseCode")
        }

        connection.disconnect()
    }
}
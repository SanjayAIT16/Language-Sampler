package com.shippo.ui

import javafx.application.Platform
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.effect.DropShadow
import javafx.scene.text.Text
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

class ShippoOrderController {

    lateinit var btnCopy: Button
    lateinit var copyableTextField: TextField
    lateinit var txtError: Text
    lateinit var btnOrderPlacement: Button

    lateinit var edtPlacedAt: TextField
    lateinit var edtOrderStatus: TextField
    lateinit var edtWeightUnitPackage: TextField
    lateinit var edtWeightPackage: TextField

    //Line item
    lateinit var edtManCon: TextField
    lateinit var edtWeightUnit: TextField
    lateinit var edtWeight: TextField
    lateinit var edtCurrency: TextField
    lateinit var edtTotalPrice: TextField
    lateinit var edtQuantity: TextField
    lateinit var edtSku: TextField
    lateinit var edtTitle: TextField

    //To Address
    lateinit var edtToEmail: TextField
    lateinit var edtToPhone: TextField
    lateinit var edtToZip: TextField
    lateinit var edtToCountry: TextField
    lateinit var edtToState: TextField
    lateinit var edtToCity: TextField
    lateinit var edtToStreet: TextField
    lateinit var edtToCompany: TextField
    lateinit var edtToName: TextField

    //From Address
    lateinit var edtFromEmail: TextField
    lateinit var edtFromPhone: TextField
    lateinit var edtFromZip: TextField
    lateinit var edtFromCountry: TextField
    lateinit var edtFromState: TextField
    lateinit var edtFromCity: TextField
    lateinit var edtFromStreet: TextField
    lateinit var edtFromCompany: TextField
    lateinit var edtFromName: TextField

    fun initialize() {
        Platform.runLater { btnOrderPlacement.requestFocus() }
        btnOrderPlacement.setOnAction {
            callApi()
        }
        addListeners()
        btnCopy.setOnAction {
            val clipBoard = Toolkit.getDefaultToolkit().systemClipboard
            val trackingNumber = copyableTextField.text
            val stringSelection = StringSelection(trackingNumber)
            clipBoard.setContents(stringSelection, null)
        }
    }

    private fun addListeners() {
        val dropShadow = DropShadow()
        dropShadow.radius = 0.0
        dropShadow.offsetX = 3.0
        dropShadow.offsetY = 3.0

        val textFieldList = listOf(
            edtFromEmail, edtFromPhone, edtFromStreet,
            edtFromCity, edtFromCountry, edtFromName, edtFromZip,
            edtToEmail, edtToPhone, edtToStreet,
            edtToCity, edtToCountry, edtToName, edtToZip,
        )

        textFieldList.forEach { textField ->
            textField.textProperty().addListener { _, _, _ ->
                textField.effect = null
            }
        }
    }

    private fun callApi() {
        val orderMap: HashMap<String, Any?> = hashMapOf()
        val lineItems: ArrayList<HashMap<String, Any?>> = arrayListOf()
        val lineItem: HashMap<String, Any?> = hashMapOf(
            "title" to edtTitle.text,
            "sku" to edtSku.text,
            "quantity" to edtQuantity.text.toLong(),
            "total_price" to edtTotalPrice.text.toDouble(),
            "currency" to edtCurrency.text,
            "weight" to edtWeight.text.toDouble(),
            "weight_unit" to edtWeightUnit.text,
            "manufacture_country" to edtManCon.text
        )
        lineItems.add(lineItem)
        orderMap["line_items"] = lineItems

        val toAddress: HashMap<String, Any?> = hashMapOf(
            "name" to edtToName.text,
            "company" to edtToCompany.text,
            "street1" to edtToStreet.text,
            "city" to edtToCity.text,
            "state" to edtToState.text,
            "zip" to edtToZip.text,
            "country" to edtToCountry.text,
            "phone" to edtToPhone.text,
            "email" to edtToEmail.text,
            "is_residential" to false,
            "metadata" to "For Order Number 123"
        )
        orderMap["to_address"] = toAddress

        val fromAddress: HashMap<String, Any?> = hashMapOf(
            "name" to edtFromName.text,
            "company" to edtFromCompany.text,
            "street1" to edtFromStreet.text,
            "city" to edtFromCity.text,
            "state" to edtFromState.text,
            "zip" to edtFromZip.text,
            "country" to edtFromCountry.text,
            "phone" to edtFromPhone.text,
            "email" to edtFromEmail.text,
            "metadata" to "Customer ID 123456"
        )
        orderMap["from_address"] = fromAddress

        orderMap["weight"] = 10.00
        orderMap["weight_unit"] = "lb"
        orderMap["order_status"] = "PAID"
        orderMap["placed_at"] = "2024-02-19T12:34:56.789Z"
        orderMap["order_number"] = "2024-02-19T12:34:56.789"
        orderMap["currency"] = "USD"
        orderMap["shipping_method"] = "ground"
        orderMap["shipping_cost"] = 1.23
        orderMap["shipping_cost_currency"] = "USD"
        orderMap["subtotal_price"] = 2.34
        orderMap["total_price"] = 6.14
        orderMap["total_tax"] = 2.57
        orderMap["notes"] = null
        orderMap["test"] = true

        copyableTextField.text = APICaller.orderApi(orderMap, "https://e605-14-102-2-85.ngrok-free.app/order")
    }
}

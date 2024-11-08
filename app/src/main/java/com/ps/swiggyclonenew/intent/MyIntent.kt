package com.ps.swiggyclonenew.intent


sealed class MyIntent {

    data class Search(val query: String) : MyIntent()


//    data class RemoveFromCart(
//        val product: Product,
//        val count: Int,
//        val eventSection: String = EMPTY_STRING,
//        val eventCodeOrigenPedido: String,
//        val eventId: String = EMPTY_STRING,
//        val onSuccess: (() -> Unit),
//    ) : MyIntent()
}

/**
 * Sealed class representing UI intents
 */
sealed class UIEvent {
    data class ShowToast(val message: String) : UIEvent()
    data class Navigate(val route: String) : UIEvent()
}


//sealed class CaminoBrillanteViewStates {
//
//    data class LoadedData(
//        val showLoader: Boolean = false,
//        val isRefreshing: Boolean = false,
//        val trackedSections: MutableList<Boolean> = MutableList(1) { false },
//        val data: CaminoBrillanteDataModel,
//
//        ) : CaminoBrillanteViewStates()
//
//    data class Offline(
//        val showLoader: Boolean = false,
//        val isRefreshing: Boolean = false,
//        val offlineErrorModel: OfflineErrorModel,
//    ) : CaminoBrillanteViewStates()
//
//    data class Error(
//        val showLoader: Boolean = false,
//        val isRefreshing: Boolean = false,
//        val apiErrorContentModel: ApiErrorModel = ApiErrorModel.emptyValue,
//    ) : CaminoBrillanteViewStates()
//
////    data class InitialLoading(
////        val showLoader: Boolean = false,
////        val isRefreshing: Boolean = false,
////    ) : CaminoBrillanteViewStates()
////
////    data object UnInitialized : CaminoBrillanteViewStates()
//
//}

/**
 * Data class representing the overall view state
 */
//data class CaminoBrillanteViewState(
//    var brillanteViewState: CaminoBrillanteViewStates,
//) : ViewState

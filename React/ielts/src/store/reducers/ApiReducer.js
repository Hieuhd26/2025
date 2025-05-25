import ActionType from "../actions/ActionType";

const initState = {
    homeData: []
}

const apiReducer = (state = homeData, action)=>{
        switch(action.type){
            case ActionType.GET_HOME:
                return state
            default:
                break
        }
}

export default apiReducer

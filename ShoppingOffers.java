package com.practice.leetcode;

import java.util.*;

/**
 * Created by Ruchit on 26-12-2017.
 */
public class ShoppingOffers {
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2,5);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(3,0,5), Arrays.asList(1,2,10));
        List<Integer> needs = Arrays.asList(3,2);
        System.out.println(shoppingOffers(price, special, needs));
    }

    private static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> history = new HashMap<>();
        return calculateMinCost(price, special, needs, history);
    }

    private static int calculateMinCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> history) {
        if(history.get(needs) != null){
            return history.get(needs);
        }
        else{
            int ans = costWithoutOffer(needs, price);
            List<Integer> remainingNeeds;
            for(int i=0; i<special.size(); i++){
                List<Integer> currentOffer = special.get(i);
                remainingNeeds = remainder(currentOffer, needs);
                if(!remainingNeeds.isEmpty()){
                    ans = Math.min(ans, currentOffer.get(currentOffer.size()-1) + calculateMinCost(price, special, remainingNeeds, history));
                }
            }
            history.put(needs, ans);
            return ans;
        }
    }

    private static List<Integer> remainder(List<Integer> currentOffer, List<Integer> needs) {
        List<Integer> remainingNeeds = new ArrayList<>();
        int difference;
        for(int i=0; i<needs.size(); i++){
            difference = needs.get(i) - currentOffer.get(i);
            if(difference < 0){
                break;
            }
            remainingNeeds.add(difference);
        }
        return remainingNeeds.size() == needs.size() ? remainingNeeds : new ArrayList<>();
    }

    private static int costWithoutOffer(List<Integer> needs, List<Integer> price) {
        int cost = 0;
        for(int i=0; i<needs.size(); i++){
            cost+=needs.get(i) * price.get(i);
        }
        return cost;
    }
}

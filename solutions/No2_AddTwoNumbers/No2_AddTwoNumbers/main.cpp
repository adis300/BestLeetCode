//
//  main.cpp
//  No2_AddTwoNumbers
//
//  Created by Disi A on 7/15/15.
//  Copyright (c) 2015 VoteBin.com. All rights reserved.
//
//

// Problem:
// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// 
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
// /*
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     ListNode *next;
//  *     ListNode(int x) : val(x), next(NULL) {}
//  * };
//  */
//



#include <iostream>
using namespace std;

// Define the node struct
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

// ---------------------------------------------------------------------
//                  36 ms Recursion solution
// ---------------------------------------------------------------------

class Solution {
public:

    void addTwo(ListNode* list1, ListNode* list2, ListNode* newListParent, int shouldFlipNext){
        int digit;
        if (list1 == NULL) {// list 1 is null
            
            if(list2 == NULL){// Check list2, if list 2 is also NULL, do a simple flip of the next node;
                if (shouldFlipNext) newListParent -> next = new ListNode(1);
                
            }else{// list2 is ok, put all list 2 data into our target list node.
                newListParent -> next = list2;
                if (shouldFlipNext) {
                    if (list2 -> val == 9) {
                        newListParent -> next -> val = 0;
                        // Recall the computation with the fliping of the next.
                        addTwo(NULL, list2 -> next, newListParent -> next,  1);
                    }else newListParent -> next -> val += 1;
                }
            }
        }else{
            
            // Check list2, if list is NULL, assign all list1 data, this similar function was re-written to improve speed
            if(list2 == NULL){
                
                newListParent -> next = list1;
                if (shouldFlipNext) {
                    if (list1 -> val == 9) {
                        newListParent -> next -> val = 0;
                        // Recall the computation with the fliping of the next.
                        addTwo(NULL, list1 -> next, newListParent -> next,  1);
                    }else newListParent -> next -> val += 1;
                }
                
            }else{// List 1 and two are find, sum up and go to the next digit.
                
                digit = list1 -> val + list2 -> val + shouldFlipNext;
                
                if (digit > 9) {
                    digit -= 10;
                    newListParent -> next = new ListNode(digit);
                    addTwo(list1 -> next, list2 -> next, newListParent -> next, 1);
                }else{
                    newListParent -> next = new ListNode(digit);
                    addTwo(list1 -> next, list2 -> next, newListParent -> next, 0);
                }
                
            }
        }
    }
    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        if (l1 != NULL && l2 != NULL) {
            int digit = l1 -> val + l2 -> val;
            ListNode* headNode;
            ListNode* currentNode;
            if (digit > 9) {
                headNode = new ListNode(digit - 10);
                currentNode = headNode;
                addTwo(l1 -> next, l2 -> next, currentNode, 1);
            }else{
                headNode = new ListNode(digit);
                currentNode = headNode;
                addTwo(l1 -> next, l2 -> next, currentNode, 0);
            }
            
            return headNode;
        }else if(l1 == NULL) return l2;
        else return l1;
    }
};


// ---------------------------------------------------------------------
//      !!!!! THIS IS NOT PART OF SOLUTION  !!!!!!!!
//      Debug helper function
// ---------------------------------------------------------------------


void printAll(ListNode* node){
    do{
        cout << "Current node value: " << node -> val << endl;
        node = node -> next;
    }while(node != NULL);
}

int main(int argc, const char * argv[]) {
    ListNode* l1 = new ListNode(9);
    l1 -> next = new ListNode(9);
    ListNode* l2 = new ListNode(9);
    ListNode* res;
    Solution solution;
    res = solution.addTwoNumbers(l1, l2);
    printAll(res);
    return 0;
}

// ---------------------------------------------------------------------
//              36 ms:  Iteration approach 36 ms.
// ---------------------------------------------------------------------

//class Solution {
//public:
//    ListNode* addFlipToNode(ListNode* list, int flip){
//        ListNode * head = list;
//        if (list == NULL && flip) {
//            head = new ListNode(1);
//            return head;
//        }
//
//        while(list != NULL && flip){
//            list -> val += 1;
//            if (list -> val > 9) {
//                list -> val -= 10;
//                flip = 1;
//            }else{
//                flip = 0;
//            }
//            if(list -> next == NULL && flip){
//                list -> next = new ListNode(1);
//                flip = 0;
//            }
//            list = list -> next;
//        }
//        return head;
//    }
//
//    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//
//        int flip = 0;
//        int digit = l1 -> val + l2 -> val;;
//
//        if (digit > 9) {
//            flip = 1;
//            digit -= 10;
//        }
//        ListNode* headNode = new ListNode(digit);
//        ListNode* currentNode = headNode;
//        l1 = l1 -> next;
//        l2 = l2 -> next;
//
//        while (l1 != NULL && l2 != NULL){
//
//            digit = l1 -> val + l2 -> val + flip;
//
//            if (digit > 9) {
//                flip = 1;
//                currentNode -> next = new ListNode(digit - 10);
//            }else {
//                flip = 0;
//                currentNode -> next = new ListNode(digit);
//            }
//            l1 = l1 -> next;
//            l2 = l2 -> next;
//
//            currentNode = currentNode -> next;
//        }
//
//        if(l1 == NULL){
//            currentNode -> next  = this -> addFlipToNode(l2, flip);
//        }else{
//            currentNode -> next  = this -> addFlipToNode(l1, flip);
//        }
//
//
//        return headNode;
//    }
//};

// ---------------------------------------------------------------------
//              40 ms:  More elegant but slower solution of the standard
// ---------------------------------------------------------------------

//class Solution {
//public:
//
//    void addTwo(ListNode* list1, ListNode* list2, ListNode* newListParent, bool shouldFlipNext){
//        int digit;
//        if (list1 == NULL && list2 == NULL) {
//            if (shouldFlipNext) {
//                newListParent -> next = new ListNode(1);
//            }
//            return;
//        }else if(list1 == NULL){// list 1 is NULL:  Assign all data to list 2
//            newListParent -> next = list2;
//            if (shouldFlipNext) {
//                if (list2 -> val == 9) { // Is going to the next digit
//                    newListParent -> next -> val = 0;
//                    addTwo(NULL, list2 -> next, newListParent -> next,  true);
//                }else
//                    newListParent -> next -> val += 1;
//            }
//            return;
//        }else if(list2 == NULL){// list 2 is NULL : Assign all list 1 to the new list we are maitaining
//            newListParent -> next = list1;
//            if (shouldFlipNext) {
//                if (list1 -> val == 9) {
//                    newListParent -> next -> val = 0;
//                    addTwo(NULL, list1 -> next, newListParent -> next,  true);
//                }else{
//                    newListParent -> next -> val += 1;
//                }
//            }
//            return;
//        }
//
//        if(shouldFlipNext){
//            digit = list1 -> val + list2 -> val + 1;
//        }else{
//            digit = list1 -> val + list2 -> val;
//        }
//
//        if (digit > 9) {
//            digit -= 10;
//            newListParent -> next = new ListNode(digit);
//            addTwo(list1 -> next, list2 -> next, newListParent -> next, true);
//        }else{
//            newListParent -> next = new ListNode(digit);
//            addTwo(list1 -> next, list2 -> next, newListParent -> next, false);
//        }
//
//    }
//
//    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//        // Make sure we have valid lists to work with;
//
//        if (l1 != NULL && l2 != NULL) {
//            // Declare a new list head and remember it;
//            ListNode* headNode;
//            ListNode* currentNode;
//
//            int digit = l1 -> val + l2 -> val; // Compute the raw digit sum;
//
//            if (digit > 9) {
//                headNode = new ListNode(digit - 10);
//                currentNode = headNode;
//                addTwo(l1 -> next, l2 -> next, currentNode, true);
//            }else{
//                headNode = new ListNode(digit);
//                currentNode = headNode;
//                addTwo(l1 -> next, l2 -> next, currentNode, false);
//            }
//            return headNode;
//        }else if(l1 == NULL) return l2;
//        else return l1;
//    }
//};



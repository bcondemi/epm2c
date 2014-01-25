/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.brunocondemi.pdiemc.logic;

import com.brunocondemi.pdiemc.model.Parameter;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public interface IProcessExecutor {
    public void runProcess(String path, ArrayList<Parameter> params);
    
}
